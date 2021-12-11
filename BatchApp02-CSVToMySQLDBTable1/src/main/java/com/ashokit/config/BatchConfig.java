package com.ashokit.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ashokit.listener.JobMoniteringListener;
import com.ashokit.model.Employee;
import com.ashokit.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	
	
	//listener
	@Bean
	public JobExecutionListener createListener() {
		return new JobMoniteringListener();
		
	}
	//Processor
	public ItemProcessor<Employee,Employee> createProcessor(){
		return new EmployeeInfoItemProcessor();
	}
	
	//Reader
	// Recommanded aproach
/*	@Bean(name="reader")
  	public ItemReader<Employee> createReader(){
		//create object for flatFileItemReader
		 FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		 // set source csv file location
		 reader.setResource(new ClassPathResource("employee_Info.csv"));
		 //reader.setResource(new FileSystemResource("e:\\abc\\employee_Info.csv"));
		 //reader.setResource(new UrlResource("http://nit.com/csv/employee_Info.csv"));
		 // set line mapper
		 reader.setLineMapper(new DefaultLineMapper<Employee>(){{
			//set LineTokenizer
			 setLineTokenizer(new DelimitedLineTokenizer() {{
				 setDelimiter(",");
				 setNames("empno","ename","salary","eadd");
			 }});
			 //set FieldSetMapper to write each Line content to Model obj
			 setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
				 setTargetType(Employee.class);
				 
			 }});
		 }});
		return reader;
	}*/
	
	
	/*@Bean(name="reader")
	  public ItemReader<Employee> createReader(){
		//create object for flatFileItemReader
		 FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		 // set source csv file location
		 reader.setResource(new ClassPathResource("employee_Info.csv"));
		 //reader.setResource(new FileSystemResource("e:\\abc\\employee_Info.csv"));
		 //reader.setResource(new UrlResource("http://nit.com/csv/employee_Info.csv"));
		 //line mapper
		 DefaultLineMapper<Employee> lineMapper=new DefaultLineMapper<Employee>();
		 //Line Tokenizer
		 DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		 lineTokenizer.setDelimiter(",");
		 lineTokenizer.setNames("empno","ename","salary","eadd");
		 //FieldSet mapper
		 BeanWrapperFieldSetMapper<Employee> mapper=new BeanWrapperFieldSetMapper<Employee>();
		 mapper.setTargetType(Employee.class);
		 //add LineTokenizr, FieldSetMapper to LineMapper
		 lineMapper.setLineTokenizer(lineTokenizer);
		 lineMapper.setFieldSetMapper(mapper);
		 //add LineMapper to Reader
		 reader.setLineMapper(lineMapper);
		return reader;
	}*/
	

	 @Bean(name="reader") 
	 public ItemReader<Employee> createReader(){ 
		 return new FlatFileItemReaderBuilder<Employee>()
		 		.name("file-reader")
		 		.resource(new ClassPathResource("Employee_Info.csv")) 
				.delimited()
				.delimiter(",")
				.names("empno","ename","salary","eadd") 
				.targetType(Employee.class) 
				.build();	//// makes to use DefaultLineMapper, DefaultLineTokenizer
	  }
	 
	
	//Writer

	@Bean(name="writer") 
	 public ItemWriter<Employee> createWriter(){
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter(); 
		//set DataSource 
		writer.setDataSource(ds); 
		//Set Sql Query with named parameter
		writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eadd,:grossSalary,:netSalary)"); 
		//set Model class obj as SqlParameterSourceProvider (here named param names and Model class obj property name must match
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>()); 
	  	return writer; 
	  }
	 
/*	@Bean(name="writer")
	public ItemWriter<Employee> createWriter(){
		return new JdbcBatchItemWriterBuilder<Employee>()
							.dataSource(ds)
							.sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eadd,:grossSalary,:netSalary)")
							.beanMapped()		// makes to use BeanPropertyItemSqlParameterSourceProvider internally
							.build();
	}*/
	
	@Bean(name="step1")
	public Step createStep1() {
		return stepFactory.get("step1")
				.<Employee,Employee>chunk(3)
				.reader(createReader())
				.writer(createWriter())
				.processor(createProcessor())
				.build();
	}
	
	@Bean(name="job")
	public Job createJob1() {
		return jobFactory.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(createListener())
				.start(createStep1())
				.build();
	}
}

package com.ashokit.config;


import javax.sql.DataSource;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashokit.listener.JobMoniteringListener;
import com.ashokit.mapper.ExamResultRowMapper;
import com.ashokit.model.ExamResult;
import com.ashokit.processer.ExamResultItemProcesser;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jobfactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	
	//listener
	  @Bean
	public JobExecutionListener createListener() {
		return new JobMoniteringListener();
		}
	  //processor
	  public ItemProcessor<ExamResult,ExamResult> createProcessor(){
		  return new ExamResultItemProcesser();		  
	  }
	/*  @Bean
	  public JdbcCursorItemReader<ExamResult> createReader(){
		  //create object
		  JdbcCursorItemReader<ExamResult> reader=new JdbcCursorItemReader<>();
		  //specify DataSource
		  reader.setDataSource(ds);
		  //specify Sql Query
		  reader.setSql("SELECT ID, DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT");
		  //specify RowMapper
		 // reader.setRowMapper(new ExamResultRowMapper());
		  reader.setRowMapper((rs,rowNumber)->new ExamResult(rs.getInt(1),
				  																									rs.getDate(2),
				  																									rs.getDouble(3),
				  																									rs.getInt(4)));
		  return reader;
	  }*/
	  public JdbcCursorItemReader<ExamResult> createReader(){
		  //create and return object
		  return new JdbcCursorItemReaderBuilder<ExamResult >()
				  				.dataSource(ds)
				  				.sql("SELECT ID, DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT")
				  				.beanRowMapper(ExamResult.class)		// Internally use BeanPropertyRowMapper
				  																						// to convert the record of RS to given Model class obj
				  																						// but db table col names and Model class properties name must match
				  				.build();
	  }
}

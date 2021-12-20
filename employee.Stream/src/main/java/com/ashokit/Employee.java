//	Note: - Map is used to get (or perform operation on) a particular field of every object 
//	Note: - Filter and map return the object of streams so we can convert it through collect(Collectors.toList() into collection
//	Note: - collect () returns collection object may be based on parameter passed
//	Note: - stream.collect(Collectors.maxBy(Comparator.comparingInt(comaprevalue))) method, 
//			stream.collect(Collectors.minBy(Comparator.comparingInt(comaprevalue))) method,
//			stream.max(Comparator.comparingInt(comaprevalue)), 
//			stream.min(Comparator.comparingInt(comaprevalue)) stream method
//			returns maximum element wrapped in an Optional object.
//			Theses methods are same and return optional<> object
//	Note: - All Collectors.() methods calls within collect() method
//	Note: - We can use forEach(System.out::println) on collection and stream object.
			// forEach with map collection we use enterySet().forEach(System.out::println)
//	Note: - We can not print directly stream object reference variable so we change it in to collection by toList() like method 
package com.ashokit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;

public class Employee
	{
	    int id;
	    String name;
	    int age;
	    String gender;
	    String department;
	    int yearOfJoining;
	    double salary;

	    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
	    {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	        this.department = department;
	        this.yearOfJoining = yearOfJoining;
	        this.salary = salary;
	    }
	     
	    public int getId() 
	    {
	        return id;
	    }
	     
	    public String getName() 
	    {
	        return name;
	    }
	     
	    public int getAge() 
	    {
	        return age;
	    }
	     
	    public String getGender() 
	    {
	        return gender;
	    }
	     
	    public String getDepartment() 
	    {
	        return department;
	    }
	     
	    public int getYearOfJoining() 
	    {
	        return yearOfJoining;
	    }
	     
	    public double getSalary() 
	    {
	        return salary;
	    }
	     
	    @Override
	    public String toString() 
	    {
	        return "Id : "+id
	                +", Name : "+name
	                +", age : "+age
	                +", Gender : "+gender
	                +", Department : "+department
	                +", Year Of Joining : "+yearOfJoining
	                +", Salary : "+salary;
	    }
	    
	public static void main(String args[]) {
//2) List Of Employees : employeeList

	List<Employee> employeeList = new ArrayList<Employee>();
	employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//1 How many Male & Female employee
System.out.println("======== no of male and female employee =========");
	Map<String, Long> noOfMaleAndFemaleEmployees = 
		employeeList
		.stream()
		.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	System.out.println(noOfMaleAndFemaleEmployees);
	
		//OR
	
	Map<String, Long> noOfMaleAndFemaleEmployees1 = 
			employeeList
			.stream()
			.collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
			System.out.println(noOfMaleAndFemaleEmployees1);
	
//2 Name of all departments
System.out.println("======== name of all departments =========");
			employeeList.stream()
						.map(Employee::getDepartment)
						.distinct()
						.forEach(System.out::println);
			//or			
			employeeList.stream()
						.map(e->e.getDepartment())
						.distinct()
						.forEach(System.out::println);
			//OR			
			List<String> collect = 
					employeeList.stream()
							.map(e->e.getDepartment())
							.distinct()
							.collect(Collectors.toList()); // to convert Stream object into List collection object
			System.out.println(collect);
			
//3 Average age of male & female
System.out.println("======== Average age of amle & female employee =========");
			Map<String, Double> avgAgeOfMaleAndFemaleEmployees = 
					employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
			System.out.println(avgAgeOfMaleAndFemaleEmployees);
			
// total employee in HR department
System.out.println("======== total employee in HR department =========");
			Long totalEmployeeInHRDepartment = 
					employeeList.stream()
					.filter(e->e.getDepartment()=="HR")
					.collect(Collectors.counting());
			System.out.println(totalEmployeeInHRDepartment);
			
			//OR
			
			Map<Object, Long> totalEmployeeInHRDepartment1 = 
					employeeList.stream()
					.filter(e->e.getDepartment()=="HR")
					.collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
			System.out.println(totalEmployeeInHRDepartment1);
			
// Average salary of Female employee
System.out.println("======== Average salary of female employee =========");
			Double avgSalaryOfFemaleEmployees = 
					employeeList.stream()
					.filter(e->e.getGender()=="Female")
					.collect(Collectors.averagingDouble(t->t.getSalary()));
			System.out.println(avgSalaryOfFemaleEmployees);
			//or
			Map<String, Double> avgSalaryOfFemaleEmployees1=
					employeeList.stream().filter(e->e.getGender()=="Female")
					.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
			System.out.println(avgSalaryOfFemaleEmployees1);

//4 Get the details of highest paid employee in the organization?
System.out.println("======== highest paid employee =========");
			Optional<Employee> detailsOfHighestPaidEmployee = 
					employeeList.stream()
					.collect(Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())));
			System.out.println(detailsOfHighestPaidEmployee.toString());
			//or
			Optional<Employee> detailsOfHighestPaidEmployee1 = 
					employeeList.stream().max(Comparator.comparingDouble(e->e.getSalary()));
			System.out.println("--"+detailsOfHighestPaidEmployee1.toString());
			//OR
			Optional<Employee> detailsOfHighestPaidEmployee2 = 
					employeeList.stream()
						.max(Comparator.comparingDouble(e->e.getSalary()));
					System.out.println("--"+detailsOfHighestPaidEmployee2.toString());
//5 employee who joined after 2015
System.out.println("========== name of employees who joined after 2015 ==========");
			employeeList.stream()
			.filter(e->e.getYearOfJoining()>2015)
			.map(e->e.getName())
			.forEach(System.out::println);

System.out.println("======= Details of employees who joined after 2015 ==========");
			employeeList.stream()
			.filter(e->e.getYearOfJoining()>2015)
			.forEach(System.out::println);

//6 Count the number of employees in each department?
System.out.println("======== number of employees in each department =========");
			Map<String, Long> employeeCountByDepartment=
			employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
			System.out.println(employeeCountByDepartment.toString());
			//OR
System.out.println("---------Another short way of printing data from map");
            employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
            					.entrySet()
            					.forEach(System.out::println);
            //OR
System.out.println("another method to print");
			System.out.println(employeeCountByDepartment);
			//OR
System.out.println("2nd way of printing data from map");
			employeeCountByDepartment.entrySet().forEach(e->{
            	System.out.println(e.getKey()+"-----"+e.getValue());
            });
System.out.println("3rd way of printing data from map");
            employeeCountByDepartment.forEach((k,v)->{
            	System.out.println(k+"----"+v);
            });  
System.out.println("Another short way of printing data from map");
            employeeCountByDepartment.entrySet().forEach(System.out::println);
           					
//7 What is the average salary of each department?
System.out.println("===========average salary of each department=============================");           
            employeeList.stream()
            			.collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(t->t.getSalary())))
            			.entrySet()
            			.forEach(System.out::println);
            
// 8 Get the details of youngest male employee in the product development department?         
            Employee employee = employeeList.stream()
            .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
            .min(Comparator.comparingInt(Employee::getAge)).get();
            System.out.println(employee);
//Explanation of previous method         
            Optional<Employee> min = employeeList.stream()
            			.filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development")
            			.min(Comparator.comparingInt(t->t.getYearOfJoining()));
            Employee youngestMaleEmployee  = min.get();
            System.out.println(youngestMaleEmployee);
            
//query 3.9 : Who has the most working experience in the organization?
System.out.println("-------------uery 3.9 : Who has the most working experience in the organization?--------------");
            Employee employee2 = employeeList.stream()
            								.min(Comparator.comparingInt(e->e.yearOfJoining))
            								.get();
System.out.println(employee2);
            //OR
            Employee employee3 = employeeList.stream()
            								.sorted(Comparator.comparingInt(e->e.getYearOfJoining()))
            								.findFirst()
            								.get();
System.out.println(employee3);
            //OR
System.out.println(employeeList.stream()
            			.min(Comparator.comparingInt(e->e.getYearOfJoining()))
            			.get());
            //OR
System.out.println(employeeList.stream()
            			.sorted(Comparator.comparingInt(e->e.getYearOfJoining()))
            			.findFirst()
            			.get());
//10 : How many male and female employees are there in the sales and marketing team?
Map<String, Long> noOfMaleAndFemaleEmployeeInSales = 
								employeeList.stream()
								.filter(e->e.getDepartment()=="Sales And Marketing")
								.collect(Collectors.groupingBy(t->t.getGender(),Collectors.counting()));
     System.out.println(noOfMaleAndFemaleEmployeeInSales);            
     //or
     employeeList.stream()
     			.filter(e->e.getDepartment()=="Sales And Marketing")
     			.collect(Collectors.groupingBy(t->t.getGender(),Collectors.counting()))
     			.entrySet()
     			.forEach(System.out::println);
// 11 : What is the average salary of male and female employees?
     employeeList.stream()
     				.collect(Collectors.groupingBy(e->e.getGender(), Collectors.averagingDouble(t->t.getSalary())))
     				.entrySet()
     				.forEach(System.out::println);
//12 list of employee in each department
    		 employeeList.stream()
    		 			.collect(Collectors.groupingBy(Employee::getDepartment))
    		 			.entrySet()
    		 			.forEach(System.out::println);
//13 : What is the average salary and total salary of the whole organization?
    		 DoubleSummaryStatistics collect2 = employeeList.stream()
    		 			.collect(Collectors.summarizingDouble(e->e.getSalary()));
    		 System.out.println("Average salary of the organization = "+collect2.getAverage());
    		 System.out.println("Total salary of the organization = "+collect2.getSum());
    		 
//14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
     		//Map<Boolean, List<Employee>> collect3 = 
    		 employeeList.stream()
     					.collect(Collectors.partitioningBy(e->e.getAge()>25)).entrySet().forEach(System.out::println);
 				
	}
	}
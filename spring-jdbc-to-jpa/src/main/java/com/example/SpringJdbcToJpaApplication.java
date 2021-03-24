
package com.example;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.StudentEntity.Student;
import com.example.StudentRepository.StudentRepository;


@SpringBootApplication
public class SpringJdbcToJpaApplication    {
    
	
	
	
	
	public static void main(String[] args) {
		
	SpringApplication.run(SpringJdbcToJpaApplication.class, args);
		
	}


	
   
	

	
	
  }
	
  


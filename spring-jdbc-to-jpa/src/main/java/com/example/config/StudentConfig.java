package com.example.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.StudentEntity.Student;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.StudentRepository"},
                       entityManagerFactoryRef = "entityManagerFactoryA", 
                       transactionManagerRef = "transactionManagerA")
public class StudentConfig {

	
	@Primary
    @Bean(name = "dataSourceA")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
	
	 @Primary
	    @Bean(name = "entityManagerFactoryA")
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
	                                                                       @Qualifier("dataSourceA") DataSource dataSource) {
	        return builder
	            .dataSource(dataSource)
	            .packages("com.example.StudentEntity")
	            .persistenceUnit("datasourceA")
	            .build();
	    }
	
	 @Primary
	    @Bean(name = "transactionManagerA")
	    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryA") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
	
	
}

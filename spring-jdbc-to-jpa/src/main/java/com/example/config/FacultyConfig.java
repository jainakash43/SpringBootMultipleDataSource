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

import com.example.FacultyEntity.Faculty;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;




@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.FacultyRepository"},
                       entityManagerFactoryRef = "entityManagerFactoryB", 
                       transactionManagerRef = "transactionManagerB")
public class FacultyConfig {

	
	
	
    @Bean(name = "dataSourceB")
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
    @Bean(name = "entityManagerFactoryB")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("dataSourceB") DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages("com.example.FacultyEntity")
            .persistenceUnit("datasourceB")
            .build();
    }
    
    @Bean(name = "transactionManagerB")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryB") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

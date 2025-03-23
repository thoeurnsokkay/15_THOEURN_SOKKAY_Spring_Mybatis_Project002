package com.example.mybatis.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
//        source.setDriverClassName("jdbc:postgresql://localhost:5432/my_batis");
        source.setUrl("jdbc:postgresql://localhost:5432/my_batis");
        source.setUsername("postgres");
        source.setPassword("1234");

        return source;
    }
}

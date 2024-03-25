package com.jugglehive.backend;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        @SuppressWarnings("rawtypes")
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://${env.DOMAIN}:5432/${env.POSTGRES_DATABASE}");
        dataSourceBuilder.username("${env.POSTGRES_USER}");
        dataSourceBuilder.password("${env.POSTGRES_PASSWORD}");
        return dataSourceBuilder.build();
    }
    
}
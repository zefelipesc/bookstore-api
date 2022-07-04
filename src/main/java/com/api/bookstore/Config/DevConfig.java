package com.api.bookstore.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.bookstore.services.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBServices dbServices;

    // get the value "create" of application-dev.properties to create our database instance every time we run the application
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDataBase() {
        if (strategy.equals("create")) {
            this.dbServices.instantiateDataBase();
        }
        return false;
    }
}

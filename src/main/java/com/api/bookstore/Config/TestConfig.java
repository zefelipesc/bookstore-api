package com.api.bookstore.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.bookstore.services.DBServices;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBServices dbServices;

    // Every time we instantiate the application, and the active profile at application.properties is "test", it will see the notation @Profile here
    // and identify that this is the test profile, and will kind of run the instantiateDataBase method.
    @Bean
    public void instantiateDataBase() {
        this.dbServices.instantiateDataBase();
    }
}

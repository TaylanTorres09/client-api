package br.com.project.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.client.services.StartDBService;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private StartDBService service;

    @Bean
    public void instatiateDataBase() {
        service.instatiateDataBase();
    }

}

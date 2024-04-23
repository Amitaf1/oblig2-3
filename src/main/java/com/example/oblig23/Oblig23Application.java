package com.example.oblig23;

import com.example.oblig23.billett.Billett;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Oblig23Application {

    private static final Logger log = LoggerFactory.getLogger(Oblig23Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Oblig23Application.class, args);
    }

    @Bean
    CommandLineRunner runner (){
        return args -> {
            Billett billett = new Billett(1,
                    "Mamma Mia!", 1,
                    "Ali", "Ali",
                    12345678, "a@a.com");
            log.info("Billett: " + billett);
        };
    }

}
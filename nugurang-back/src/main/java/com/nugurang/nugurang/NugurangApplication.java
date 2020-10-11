package com.nugurang.nugurang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories("com.nugurang.dao")
@EntityScan("com.nugurang.entity")
@SpringBootApplication(scanBasePackages = {"com.nugurang.*"})
public class NugurangApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NugurangApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

package com.nugurang.nugurang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.nugurang.repository")
@EntityScan("com.nugurang.entity")
@SpringBootApplication
public class NugurangApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NugurangApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

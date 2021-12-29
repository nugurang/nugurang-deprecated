package com.nugurang.nugurang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.nugurang", "com.nugurang.*"})
public class NugurangApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NugurangApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

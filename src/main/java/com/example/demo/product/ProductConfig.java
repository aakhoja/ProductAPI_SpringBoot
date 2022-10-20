package com.example.demo.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository)
    {
        return args -> {
            Product elfBar = new Product(
                    "JGH67639",
                    "Elf Bar 10ct",
                    97.50,
                    76
            );
            Product escoBar = new Product(
                    "LKJU7676",
                    "Esco Bar 10ct",
                    75.00,
                    52
            );
            productRepository.saveAll(List.of(elfBar,escoBar));
        };
    }
}

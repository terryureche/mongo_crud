package com.terry.mongo_crud;

import com.terry.mongo_crud.db.mongo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrettyShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PrettyShopApplication.class, args);
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {

    }
}

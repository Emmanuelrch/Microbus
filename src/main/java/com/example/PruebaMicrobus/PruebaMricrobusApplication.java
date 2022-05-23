package com.example.PruebaMicrobus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EntityScan("com.example.model.*")
@ComponentScan("com.example")
@ComponentScan("com.example.PruebaMicrobus")
@EnableWebMvc
@SpringBootApplication
public class PruebaMricrobusApplication {

  public static void main(String[] args) {
    SpringApplication.run(PruebaMricrobusApplication.class, args);
  }
}

package com.seneca.global.todoservice;


import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@EnableAutoConfiguration
@OpenAPIDefinition(info=@Info(title="TODO service application"))
@ComponentScan(
      basePackages = {
            "com.seneca.global.*"
      })
public class TodoServiceApplication {

   public static void main(String[] args) {
      SpringApplication.run(TodoServiceApplication.class, args);
   }

   @PostConstruct
   public void init(){
     TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
   }
}

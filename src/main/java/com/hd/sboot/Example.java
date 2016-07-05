package com.hd.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Configuration;

@Configuration
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/toto")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/toto/yes")
    String room() {
      return "hello in room";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
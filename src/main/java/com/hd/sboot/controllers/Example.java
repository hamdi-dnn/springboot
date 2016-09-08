package com.hd.sboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@Controller
@EnableAutoConfiguration
@RequestMapping("/example")
public class Example {

  private static final Logger logger = LoggerFactory.getLogger(Example.class);

    @RequestMapping("hello")
    String home() {
        return "index";
    }

    @RequestMapping(value="example/yes", method=RequestMethod.POST)
    String room(@RequestParam(value="name", required=false, defaultValue="world") String name, Model model) {
      model.addAttribute("name", name);
      logger.info("@Example, Name added to model: "+ name);

      return "hello";
    }


}
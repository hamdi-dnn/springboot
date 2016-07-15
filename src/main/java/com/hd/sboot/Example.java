package com.hd.sboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Configuration;

@Configuration
@Controller
@EnableAutoConfiguration
public class Example {

  private static final Logger logger = LoggerFactory.getLogger(Example.class);

    @RequestMapping("/hello")
    String home() {
        return "index";
    }

    @RequestMapping(value="/hello/yes", method=RequestMethod.POST)
    String room(@RequestParam(value="name", required=false, defaultValue="world") String name, Model model) {
      model.addAttribute("name", name);
      logger.info("@Example, Name added to model: "+ name);

      return "hello";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
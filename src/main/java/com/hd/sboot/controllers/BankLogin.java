package com.hd.sboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@Controller
@RequestMapping("/bank")
public class BankLogin {

  private static final Logger logger = LoggerFactory.getLogger(BankLogin.class);

  @RequestMapping("/portal")
  String bankhome() {
      return "bank-portal";
  }

  @RequestMapping(value="/login", method=RequestMethod.POST)
  String room(@RequestParam(value="userID", required=true) String userID,
      @RequestParam(value="password", required=true) String password,
      Model model) {
    model.addAttribute("userID", userID);

    logger.info("@BankLogin, received userID+password:" + userID + " " + password);

    return "home-account";
  }
  
  

}

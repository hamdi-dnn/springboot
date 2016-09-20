package com.hd.sboot.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hd.sboot.access.BankLoginDAO;
import com.hd.sboot.model.User;

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
  String login(@RequestParam(value="userID", required=true) String userID,
      @RequestParam(value="password", required=true) String password,
      Model model) {
    BankLoginDAO loginDAO = new BankLoginDAO();
    Optional<User> oUser = loginDAO.login(userID, password);
    if(oUser.isPresent()) {
      User user = oUser.get();
      model.addAttribute("firstName", user.getFirstName());
      model.addAttribute("lastName", user.getLastName());
      return "home-account";
    } else {
      return "bank-portal";
    }

  }



}

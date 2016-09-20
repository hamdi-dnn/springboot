package com.hd.sboot.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hd.sboot.model.User;

public class BankLoginDAO {

  private static final Logger logger = LoggerFactory.getLogger(BankLoginDAO.class);


  public Optional<User> login(String userID, String password) {
//    Class.forName("org.h2.Driver");
    Connection conn = null;
    String sqlRequest = "SELECT * FROM BANK.USERS WHERE LOGIN = '"+userID+
        "' AND PASSWORD = '"+password+"'";
    try {
      conn = DriverManager.getConnection("jdbc:h2:.\\jdbc.h2","admin","admin");
      Statement s = conn.createStatement();
      ResultSet res = s.executeQuery(sqlRequest);
      if (res.next()) { // Expecting one user
        String firstName = res.getString("FIRSTNAME");
        String lastName = res.getString("LASTNAME");
        logger.info("User logged in: "+lastName + " " + firstName);
        User user = new User(firstName, lastName);
        return Optional.ofNullable(user);
      }

      conn.close();
    }
    catch (SQLException e) {
      logger.error("Failure to retreive user", e);
    }
    finally {
      try {
        conn.close();
      }
      catch (SQLException e) {
        logger.error("Failure to close connexion to DB", e);
      }
    }
    return Optional.ofNullable(null);
  }

//  public static void main(String... arg) {// for test purpose
//    BankLoginDAO bld = new BankLoginDAO();
//
//      bld.login("admin", "passwdord");
//  }

}

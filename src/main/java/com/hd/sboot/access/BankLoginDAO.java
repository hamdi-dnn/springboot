package com.hd.sboot.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import com.hd.sboot.model.User;

public class BankLoginDAO {


  public Optional<User> login(String userID, String password) {
//    Class.forName("org.h2.Driver");
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:h2:.\\jdbc.h2","admin","admin");
      conn.close();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
//      conn.close();
    }
    return null;
  }

//  public static void main(String... arg) {
//    BankLoginDAO bld = new BankLoginDAO();
//    bld.login("id", "pw");
//  }

}

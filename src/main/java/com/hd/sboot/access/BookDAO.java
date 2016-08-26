package com.hd.sboot.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDAO {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public BookDAO() {
    super();
    jdbcTemplate.execute("DROP TABLE books IF NOT EXISTS");
    jdbcTemplate.execute("CREATE TABLE books(" +
            "id SERIAL, titles VARCHAR(255), description VARCHAR(255), img VARCHAR(255))");
  }




}

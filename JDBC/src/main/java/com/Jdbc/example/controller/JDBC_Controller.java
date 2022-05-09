package com.Jdbc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBC_Controller {
	@Autowired
	JdbcTemplate jdbc;

	@GetMapping("/Insert")
	public String create() {

		String Query = "insert into bcci (playerFirst_Name,LastName,jersey_No) values('Ms','Dhoni,7);";
		jdbc.execute(Query);
		return "Data Inserted";

	}

}

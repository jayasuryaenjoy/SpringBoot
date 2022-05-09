package com.Jdbc.example.Dao;

import java.util.List;

import com.Jdbc.example.Entity.Serole;

public interface SeroleRepository {
	
	Serole saveEmployee(Serole serole);
	Serole updateEmployee(Serole serole);
	Serole getEmployeeById(int id);
	String deleteById(int id);
	List<Serole> allEmployees();
	

}
//fdghjkl

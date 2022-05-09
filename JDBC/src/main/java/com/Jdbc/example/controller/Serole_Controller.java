package com.Jdbc.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jdbc.example.Dao.SeroleRepository;
import com.Jdbc.example.Entity.Serole;

@RestController
public class Serole_Controller {
	@Autowired
	SeroleRepository serolerepository;

	@PostMapping("/SaveEmployee")
	public Serole saveEmployee(@RequestBody Serole serole) {
		return serolerepository.saveEmployee(serole);
	}

	@PutMapping("/Update")
	public Serole updateEmployee(@RequestBody Serole serole) {
		return serolerepository.updateEmployee(serole);
	}

	@GetMapping("/GetEmployee/{idd}")
	public Serole getEmployeeById(@PathVariable("idd") int id) {

		return serolerepository.getEmployeeById(id);
	}
	@GetMapping("/GetEmployee")
	public Serole findEmployeeById(@RequestParam int id) {

		return serolerepository.getEmployeeById(id);
	}

	@DeleteMapping("/DeleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return serolerepository.deleteById(id);
	}

	@GetMapping("/AllEmployees")
	public List<Serole> allEmployees() {
		return serolerepository.allEmployees();
	}

}

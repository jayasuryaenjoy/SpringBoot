package com.Jdbc.example.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Jdbc.example.Entity.Serole;

@Repository
public class SeroleRepository_Impl implements SeroleRepository {

	private static final String INSERT_EMPLOYEE = "insert into serole (E_id,E_Name,E_Mail)values(?,?,?)";
	private static final String UPDATE_Employee_BY_ID_ = "UPDATE serole SET E_Name=? WHERE E_Id=?";
	private static final String GET_Employee_BY_ID_QUERY = "SELECT * FROM serole WHERE E_Id=?";
	private static final String DELETE_Employee_BY_ID = "delete from serole where E_Id=?";
	private static final String GET_Employees = "SELECT * FROM serole";

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Serole saveEmployee(Serole serole) {
		jdbc.update(INSERT_EMPLOYEE, serole.getE_id(), serole.getE_Name(), serole.getE_Mail());
		return serole;
	}

	@Override
	public Serole updateEmployee(Serole serole) {
		jdbc.update(UPDATE_Employee_BY_ID_, serole.getE_Name(), serole.getE_id());
		return serole;
	}

	@Override
	public Serole getEmployeeById(int id) {
		return jdbc.queryForObject(GET_Employee_BY_ID_QUERY, (rs, rowNum) -> {

			return new Serole(rs.getInt("E_Id"), rs.getString("E_Name"), rs.getString("E_Mail"));
		}, id);
	}

	@Override
	public String deleteById(int id) {
		jdbc.update(DELETE_Employee_BY_ID, id);
		return "Employee Deleted with id" + id;
	}

	@Override
	public List<Serole> allEmployees() {
		// TODO Auto-generated method stub
		return jdbc.query(GET_Employees, (rs, rowNum) -> {
			return new Serole(rs.getInt("E_Id"), rs.getString("E_Name"), rs.getString("E_Mail"));
		});
	}

}

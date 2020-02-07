package com.sapient.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.sapient.lms.model.Employee;

public class EmployeeManager {

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qe_users", "root", "root");
		return connection;
	}

	public void insertEmployee(Employee e) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = getConnection().prepareStatement("insert into lms(name,dept,leavesLeft) values(?,?,?)");
		prepStatement.setString(1, e.getName());
		prepStatement.setString(2, e.getDept());
		prepStatement.setInt(3, 20);
		prepStatement.execute();
		connection.close();
	}
	
	public void updateEmployee(int empId, Employee e) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = getConnection().prepareStatement("update lms set name=?,dept=? where id="+empId);
		prepStatement.setString(1, e.getName());
		prepStatement.setString(2, e.getDept());
		prepStatement.execute();
		prepStatement.close();
		connection.close();
		
	}
	
	public boolean searchEmployee(int empId) throws SQLException {
		Connection connection = getConnection();
		ResultSet rs = getConnection().createStatement().executeQuery("select * from lms ");
		while(rs.next()) {
			if(empId == rs.getInt(1)) {
				ResultSet result = getConnection().createStatement().executeQuery("select * from lms where id="+empId);;
				if (result.next()) {
					connection.close();
					return true;
					
				}
			}
		}
		connection.close();
		return false;

	}
	
	public Set<Employee> showEmployee() throws SQLException {
		Connection connection = getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from lms");
		Set<Employee> employee = new HashSet<Employee>();
		while(resultSet.next()) {
//			int EmpId = resultSet.getInnt("id");
			String EmpName = resultSet.getString("name");
			String EmpDept = resultSet.getString("dept");
			employee.add(new Employee(EmpName,EmpDept));
		}
		connection.close();
		return employee;
	}


}

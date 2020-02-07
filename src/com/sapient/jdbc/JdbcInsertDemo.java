package com.sapient.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertDemo {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qe_users", "root",
				"root");
				// Step 2
				Statement statement = connection.createStatement();) 
		{
			
			// execute Query - Insert 
			// statement.execute("insert into users (name, dept,email)
			// values('Vinay','HR','vinay@gmail.com')");
			
			// executeUpdate Query - Update 
			int updateCount = statement.executeUpdate("update users set name = 'Rajesh Kumar' where id=1");
			if(updateCount > 0) {
				System.out.println("Updated Records "+updateCount);
			}
			
			// executeQuery - Select 
			ResultSet resultSet = statement.executeQuery("Select * from users");

			// Step 1

			while (resultSet.next()) {
				int emptId = resultSet.getInt("id");
				String empName = resultSet.getString("name");
				String empDept = resultSet.getString("dept");
				String empEmail = resultSet.getString("email");
				System.out.println("Employee with Id: " + emptId + ", Name: " + empName + ", Dept: " + empDept
						+ ",Email: " + empEmail);
			}

			// resultSet.close();
			// // Step 4
			// statement.close();
			//
			// // Step 5
			// connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

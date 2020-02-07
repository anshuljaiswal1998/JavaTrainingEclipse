package com.sapient.lms.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sapient.lms.exception.InsufficientLeaveBalanceException;
import com.sapient.lms.model.Employee;

public class LeaveManager {

	public LeaveManager() {
		this.getconnection();
	}

	public Connection getconnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qe_users", "root",

					"root");
			Statement statement = connection.createStatement();
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int applyForLeave(int numOfLeaves, Employee e) throws InsufficientLeaveBalanceException {

		// int leavesleft = e.getDetails().numOfLeaves();
		try {
			Connection connection = getconnection();
			ResultSet rs;
			rs = connection.createStatement().executeQuery("select leavesLeft from lms where id = " + e.getEmpId());
			int nod = 0;
			if (rs.next()) {
				nod = rs.getInt("leavesLeft");
			}

			if (numOfLeaves < 20) {
				int updateCount = connection.createStatement().executeUpdate(
						"update lms set leavesLeft = '" + (nod - numOfLeaves) + "' where id=" + e.getEmpId());
				// e.getDetails().setNumOfLeaves(nod - numOfLeaves);
			} else {
				// Throw Exception
				throw new InsufficientLeaveBalanceException("Insufficient Balance");
			}
			return numOfLeaves;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return -1;
		}

	}

	public int leaveBalance(Employee e) {
		int nod = -1;
		try {
			Connection connection = getconnection();
			ResultSet rs;
			rs = connection.createStatement().executeQuery("select leavesLeft from lms where id = " + e.getEmpId());
			if (rs.next()) {
				nod = rs.getInt("leavesLeft");
			}
			return nod;
		} catch (Exception exp) {
			// TODO: handle exception
			return nod;
		}
		// return e.getDetails().getNumOfLeaves();
	}

	public int updateLeaveBalance(int numOfLeaves, Employee e) {
		// e.getDetails().numOfLeaves();
		e.getDetails().updateNumOfLeaves(numOfLeaves);
		return e.getDetails().getNumOfLeaves();

	}

}

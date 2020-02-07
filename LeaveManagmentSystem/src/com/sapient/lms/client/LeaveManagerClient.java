package com.sapient.lms.client;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sapient.lms.exception.InsufficientLeaveBalanceException;
import com.sapient.lms.model.Employee;
import com.sapient.lms.service.EmployeeManager;
import com.sapient.lms.service.LeaveManager;

public class LeaveManagerClient {

	static int val = 1;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws InsufficientLeaveBalanceException, ParseException, SQLException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Employee e1 = new Employee();
		loadUsers(e1);
		Employee e2 = new Employee();
		loadUsers(e2);
		Employee e3 = new Employee();
		loadUsers(e3);

		Set<Employee> employees = new HashSet<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		for (Employee employee : employees) {
			System.out.println(employee.getEmpId());
		}
		LeaveManager lm = new LeaveManager();

		System.out.println("Enter the Emp Id");
		int empid = scn.nextInt();
		Employee e = null;
		for (Employee employee : employees) {
			if (employee.getEmpId() == empid) {
				e = employee;
				break;
			}
		}
		// e = e1.getEmpId() == empid ? e1 : e2;

		int input = 0;
		while (input != 4) {
			// System.out.println("\n Enter the Details: ");
			System.out.println("1. View Leave Balance ");
			System.out.println("2. Apply for Leaves ");
			System.out.println("3. Update Leaves ");
			System.out.println("4. Update Employees ");
			System.out.println("5. Exit");

			input = scn.nextInt();
			switch (input) {
			case 1:
				System.out.println(lm.leaveBalance(e));
				break;
			case 2:
				System.out.println("Enter Date 1 - ");
				String date1 = scn.next();
				System.out.println(date1);
				Date d1 = dateFormat.parse(date1);
				System.out.println("Enter Date 2 - ");
				String date2 = scn.next();
				Date d2 = dateFormat.parse(date2);
				int nod = Math.abs(d2.getDate() - d1.getDate());
				// int nod = scn.nextInt();
				System.out.println(lm.applyForLeave(nod, e));
				break;

			case 3:
				int nod1 = scn.nextInt();
				System.out.println(lm.updateLeaveBalance(nod1, e));
				break;
			case 4:
				UpdateEmployees();
			case 5:
				System.exit(0);
			default:
				break;
			}
		}
	}

	public static void loadUsers(Employee e) {
		e.setEmpId(val);
		e.setName("Emp" + val);
		e.setDept("Dept" + val);
		val++;
	}

	public static void UpdateEmployees() throws SQLException {
		int input = scn.nextInt();
		EmployeeManager em = new EmployeeManager();
		System.out.println("1. Enter new Employee");
		System.out.println("2. Update Existing Employee");

		switch (input) {
		case 1:
			System.out.println("Enter Name-");
			String name = scn.next();
			System.out.println("Enter Dept-");
			String dept = scn.next();
			Employee e = new Employee(name, dept);
			em.insertEmployee(e);
			break;

		case 2:
			System.out.println("Enter ID");
			int id = scn.nextInt();
			boolean ans = em.searchEmployee(id);
			if (ans) {
				System.out.println("Enter Name-");
				String name1 = scn.next();
				System.out.println("Enter Dept-");
				String dept1 = scn.next();
				Employee e1 = new Employee(name1, dept1);
				em.updateEmployee(id, e1);
			}
			break;
		case 3:
			System.out.println("Details are ");
			Set<Employee> set = em.showEmployee();
			for (Employee employee : set) {
				System.out.println(employee);
			}
		default:
			break;
		}

	}

}

package com.sapient.lms.client;

import java.util.Scanner;

import com.sapient.lms.exception.InsufficientLeaveBalanceException;
import com.sapient.lms.model.Employee;
import com.sapient.lms.service.LeaveManager;

public class LeaveManagerClient {

	static int val = 1;

	public static void main(String[] args) throws InsufficientLeaveBalanceException {

		Employee e1 = new Employee();
		loadUsers(e1);
		Employee e2 = new Employee();
		loadUsers(e2);

		LeaveManager lm = new LeaveManager();

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Emp Id");
		int empid = scn.nextInt();
		Employee e;
		e = e1.getEmpId() == empid ? e1 : e2;

		int input = 0;
		while (input != 4) {
			System.out.println("Enter the Details: ");
			System.out.println("1. View Leave Balance ");
			System.out.println("2. Apply for Leaves ");
			System.out.println("3. Update Leaves ");
			input = scn.nextInt();

			switch (input) {
			case 1:
				System.out.println(lm.leaveBalance(e));
				break;
			case 2:
				int nod = scn.nextInt();
				System.out.println(lm.applyForLeave(nod, e));
				break;

			case 3:
				int nod1 = scn.nextInt();
				System.out.println(lm.updateLeaveBalance(nod1, e));
				break;
			case 4:
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

}

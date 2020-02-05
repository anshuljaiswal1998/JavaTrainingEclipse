package com.sapient.lms.service;

import com.sapient.lms.exception.InsufficientLeaveBalanceException;
import com.sapient.lms.model.Employee;

public class LeaveManager {

	public int applyForLeave(int numOfLeaves, Employee e) throws InsufficientLeaveBalanceException {
		int leavesleft = e.getDetails().numOfLeaves();
		if (numOfLeaves < 20) {
			e.getDetails().setNumOfLeaves(leavesleft - numOfLeaves);
		} else {
			// Throw Exception
			throw new InsufficientLeaveBalanceException("Insufficient Balance");
		}
		return numOfLeaves;
	}

	public int leaveBalance(Employee e) {
		return e.getDetails().getNumOfLeaves();
	}

	public int updateLeaveBalance(int numOfLeaves, Employee e) {
		// e.getDetails().numOfLeaves();
		e.getDetails().updateNumOfLeaves(numOfLeaves);
		return e.getDetails().getNumOfLeaves();

	}

}

package com.sapient.lms.model;

public class LeaveDetails {

	private int numOfLeaves = 20;

	public int numOfLeaves() {
		return numOfLeaves;
	}

	public int getNumOfLeaves() {
		return numOfLeaves;
	}

	public void setNumOfLeaves(int numOfLeaves) {
		this.numOfLeaves = numOfLeaves;
	}

	public void updateNumOfLeaves(int numOfLeaves) {
		this.numOfLeaves = this.numOfLeaves + numOfLeaves;
	}
}

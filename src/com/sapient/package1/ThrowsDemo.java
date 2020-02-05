package com.sapient.package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// readFile();
		try {
			throwException2(args[0]);
			System.out.println("Eligible to cast vote");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please pass the number as argument");
		} catch (NumberFormatException e) {
			System.out.println("Input should be valid Number");
		} catch (IllegalArgumentException e) {
			System.out.println("Age should be greater than 18" + e.getMessage());
		} catch (InvalidAgeException e) {
			System.out.println("Custom Exception: " + e.getMessage());
		}

	}

	private static void readFile() throws FileNotFoundException {
		FileReader reader = new FileReader(new File("C://test.txt"));
		System.out.println("Reader is " + reader);
	}

	private static void throwException(String args) {
		int age = Integer.parseInt(args);
		if (age < 18) {
			throw new IllegalArgumentException("Invalid Age for casting Vote");
		}
	}

	private static void throwException2(String age) throws InvalidAgeException {
		int numAge = Integer.parseInt(age);
		if (numAge < 18) {
			throw new InvalidAgeException("Invalid Age Exception by ME");
		}
	}

}

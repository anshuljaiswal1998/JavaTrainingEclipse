package com.sapient.package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedException {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader = null;
		int i;
		try {
			reader = new FileReader(new File("C://test.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File is not present. ");
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}

		System.out.println("Reader is " + reader);
//		System.out.println(i);

	}

}

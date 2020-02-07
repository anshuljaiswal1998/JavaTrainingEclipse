package com.sapient.fileIO;

import java.io.*;

public class FileWriterDemo {

	public static void main(String[] args){

		File file = new File("C:\\JavaTraining\\test.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file,true);
			fileWriter.append("hello to world");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				System.out.println("File Reader cannot be closed " + e.getMessage());
			}
		}
		
		
	}

}

package com.sapient.fileIO;

import java.io.*;

public class FileReaderDemo {

	public static void main(String[] args) {

		File file = new File("C:\\JavaTraining\\test.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			int c = fileReader.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fileReader.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + file.getName());
		} catch (IOException e) {
			System.out.println("File is Empty " + e.getMessage());
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				System.out.println("File Reader cannot be closed " + e.getMessage());
			}
		}
	}

}

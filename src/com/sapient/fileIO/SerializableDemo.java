package com.sapient.fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee(1, "Anshul");
		File file = new File("C:\\JavaTraining\\test.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(emp1);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		System.out.println(in.readObject().toString());
		in.close();
		
	}

}

package com.sapient.package1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Date date =  (Date) dateFormat.parse(str);
		System.out.println(date.getDay());
		SimpleDateFormat dateOutput = new SimpleDateFormat();
				
	}	

}

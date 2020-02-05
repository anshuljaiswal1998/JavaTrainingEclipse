package com.sapient.package1;

public class StringExamples {
	
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str.length());
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str.contains("ello"));
		System.out.println(str.substring(1, 3));
		
		StringBuffer sb = new StringBuffer(str);
		String res = sb.append("World").append("Wow").toString();
		System.out.println(res);
		
		String num = "455";
		int val = Integer.parseInt(num);
		System.out.println(val);
		Integer i = 12;
		int val1 = i.intValue();
		System.out.println(val1);
		
		
	}

}

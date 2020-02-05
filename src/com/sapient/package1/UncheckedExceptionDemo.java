package com.sapient.package1;

import java.text.NumberFormat;

public class UncheckedExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int arr[] = { 10, 12, 14, 16 };
			// System.out.println(arr[4]);
			// arr = null;
			System.out.println(arr[0]);
			System.out.println(Integer.parseInt("22f"));
//			 } catch (NumberFormatException ne) {
//			 System.out.println("Number Format");
//			 } catch (ArrayIndexOutOfBoundsException e) {
//			 System.out.println("Array Bound");
//			 } catch (NullPointerException e) {
//			 System.out.println("Null Pointer");
//			 // TODO: handle exception
		} catch (ArrayIndexOutOfBoundsException | NullPointerException r) {
			System.out.println("Invalid Input "+ r.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

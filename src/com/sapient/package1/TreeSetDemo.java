package com.sapient.package1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<User> users = new TreeSet<>(new ComparatorBySalary());
		User u1 = new User(1, "User 1",500);
		User u2 = new User(2, "User 2",600);
		User u4 = new User(4, "User 4",100);
		User u3 = new User(3, "User 3",900);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		
		Iterator<User> it = users.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

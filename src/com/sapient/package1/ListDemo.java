package com.sapient.package1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(14);
		list.add(21);
		list.set(1, 20);

		System.out.println(list);

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int value = it.next();
			System.out.println("The value " + value);
		}

		ListIterator<Integer> li = list.listIterator();
		while(li.hasNext()) {
			System.out.println(li.hasPrevious());
			li.next();
		}

	}
}

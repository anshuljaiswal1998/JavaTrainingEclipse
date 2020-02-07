package com.sapient.package1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<Integer, User> map = new HashMap<>();
//		map.put(1, new User(1, "Anshul"));
		User u1 = new User(1, "User 1",500);
		User u2 = new User(2, "User 2",600);
		User u4 = new User(4, "User 4",100);
		User u3 = new User(3, "User 3",900);
		
		map.put(11, u1);
		map.put(12, u2);
		map.put(13, u3);
		map.put(14, u4);
		map.put(11, u4);
		
		System.out.println(map.size());
		Set<Integer> keySet = map.keySet();
//		for (Integer num : keySet) {
//			System.out.println(map.get(num));
//		}
//		
		Collection<User> userIt = map.values();
		
//		for (User user : userIt) {
//			System.out.println(user);
//		}
//		System.out.println(map.get(12));
		
		Set<Map.Entry<Integer,User>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, User>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for (Map.Entry<Integer, User> entry : entrySet) {
			System.out.println(entry);
		}
		
	}
}

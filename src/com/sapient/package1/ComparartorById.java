package com.sapient.package1;

import java.util.Comparator;

public class ComparartorById  implements Comparator<User>{

	@Override
	public int compare(User user1, User user2) {
		
		return user2.id - user1.id;
	}
	
}

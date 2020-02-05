package com.sapient.package1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class ToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User(1,"Anshul");
		User user2 = new User(2,"Anshul Jaiswal");
		
//		Set<User> set = new HashSet<>();
//		set.add(user1);
//		set.add(user2);
//		System.out.println("Contains: "+ set.contains(user1));
////		java.util.Iterator<User>;
//		System.out.println(user1 == user2);
		
//		System.out.println(user1.equals(user2));
		
		Set<User> set = new TreeSet<>();
		set.add(user1);
		set.add(user2);
		set.add(new User(2, "Harsh"));
		System.out.println(set);
//		System.out.println(set);
		
	}
}

class User implements Comparable<User>{
	int id;
	String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(User other) {
		// TODO Auto-generated method stub
		return this.id - other.id;
	}

}

package qapractice2;

import java.util.*;

public class SecondAssignment {
	
	public static void main(String[] args) {
	ArrayList<String> members = new ArrayList<String>();
	
	members.add("Mike");
	members.add("John");
	members.add("Nick");
	members.add("Merry");
	members.add("Sara");
	
	for(int i = 0; i < members.size(); i++)
	{
		System.out.println(members.get(i));
	}
	
	System.out.println("\n--------------------------------\n");
	
	for (String name : members)
	{
		System.out.println(name);
	}
	
}	
}
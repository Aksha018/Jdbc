package com.chainsys.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.dao.UserDao;
import com.chainsys.user.User;

public class UserTest {
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int id;
		String name ,email,password;
		UserDao userDao = new UserDao();
		User user=new User();
		System.out.println("Select Option:");
		System.out.println("Enter 1 for Insert" +"\nEnter 2 for Update"+ "\nEnter 3 for delete");
		int choice = sc.nextInt();
		switch(choice) {
//		add user
		case 1 :
		System.out.println("Enter your Id");
		id = sc.nextInt();
		user.setId(20);
		
		System.out.println("Enter your Name");
		 name = sc.next();
		user.setName(name);
		
		System.out.println("Enter your Email");
		 email = sc.next();
		user.setEmail(email);
		
		System.out.println("Enter your Password");
		 password = sc.next();
		user.setPassword(password);
		
		userDao.saveUser(user);
		break;
//		update user 
		case 2:
			System.out.println("Enter your Id");
			id = sc.nextInt();
			user.setId(20);
			
			System.out.println("Enter your Name");
			 name = sc.next();
			user.setName(name);
			
			System.out.println("Enter your Email");
			 email = sc.next();
			user.setEmail(email);
			
			System.out.println("Enter your Password");
			 password = sc.next();
			user.setPassword(password);
			userDao.updateUser(user);
	    break;
//	    delete user
		case 3:
			System.out.println("Enter your Id");
			 id = sc.nextInt();
			 userDao.deleteUser(id);
	    break;
	    default:
	    	System.out.println("\nplease enter a valid option!");
		}	
	}
}
package com.chainsys.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.dao.UserDao;
import com.chainsys.user.User;

public class UserMain {
	
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		UserDao userDao = new UserDao();
		User user = new User();
		
		int userId;
		String userName;
		String Password;
		int balance = 0;
		
	System.out.println("Select Option");
	System.out.println("Enter option 1 for Insert"+"\nEnter 2 for Update"+"\nEnter 3 for Delete"+"\nEnter 4 for User List"
	+"\nEnter 5 If you are already registered"+"\nEnter 6 to Tranfer Amount");
	int choose = sc.nextInt();
	switch(choose) {
	case 1:
		System.out.println("Enter you User Id");
		 userId = sc.nextInt();
		 user.setUserId(userId);
		 
		 System.out.println("Enter you User Name");
		 userName = sc.next();
		 user.setUserName(userName);
		 
		 System.out.println("Enter you Password");
		 Password = sc.next();
		 user.setPassword(Password);
		 
		 System.out.println("Enter your Balance");
		 balance = sc.nextInt();
		 user.setBalance(balance);
		 
		 
		 userDao.insertUser(user);
		 
break;
	case 2:
		System.out.println("Enter you User Id");
		 userId = sc.nextInt();
		 user.setUserId(userId);
		 
		 System.out.println("Enter you User Name");
		 userName = sc.next();
		 user.setUserName(userName);
		 
		 System.out.println("Enter you Password");
		 Password = sc.next();
		 user.setPassword(Password);
		 
		 System.out.println("Enter your Balance");
		 balance = sc.nextInt();
		 user.setBalance(balance);
		 
		 
		 userDao.updateUser(user);
break;

	case 3:
		System.out.println("Enter your Id");
		userId = sc.nextInt();
		userDao.deleteUser(userId);
		break;
		
	case 4:
		ResultSet listUser = userDao.listUser();
		while (listUser.next()) {
			int userId1 = listUser.getInt(1);
			String userName1 = listUser.getString(2);
		    String password1 = listUser.getString(3);
		    int balance1 = listUser.getInt(4);
		    
			System.out.println(userId1);
			System.out.println(userName1);
			System.out.println(password1);
			System.out.println(balance1);
		}
  break;
	case 5:
		System.out.println("Enter you id");
		int userid = sc.nextInt();

		ResultSet registerdUser = userDao.registerdUser(userid);

		while (registerdUser.next()) {
			int userId1 = registerdUser.getInt(1);
			String userName1 = registerdUser.getString(2);
		    String password1 = registerdUser.getString(3);
		    int balance1 = registerdUser.getInt(4);
		    
		    
			System.out.println(userId1);
			System.out.println(userName1);
			System.out.println(password1);
			System.out.println(balance1);

		}
		break;
	case 6:
//		  userDao.transaction(balance,userId,);
break;
     default:
			System.out.println("\nPlease enter a valid option!"); 
		 
	
	}
		
	}
}



package com.chainsys.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.chainsys.dao.UserDao;
import com.chainsys.user.User;

public class UserTest {
	public static void main(String args[]) throws SQLException {

		Scanner sc = new Scanner(System.in);
		int id;
		String name, email, password;
		UserDao userDao = new UserDao();
		User user = new User();
		System.out.println("Select Option:");
		System.out.println("Enter 1 for Insert" + "\nEnter 2 for Update" + "\nEnter 3 for delete" + "\nEnter 4 for view"
				+ "\nEnter 5 for One User" + "\nEnter 6 for View Holidays"+"\nEnter 7 for list holidays");
		int choice = sc.nextInt();
		switch (choice) {
//		add user
		case 1:
			System.out.println("Enter your Id");
			id = sc.nextInt();
			user.setId(id);

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
//    view user
		case 4:

			ResultSet viewUser = userDao.viewUser();
			while (viewUser.next()) {
				int id1 = viewUser.getInt(1);
				String name1 = viewUser.getString(2);
				String email1 = viewUser.getString(3);
				String password1 = viewUser.getString(4);
				System.out.println(id1);
				System.out.println(name1);
				System.out.println(email1);
				System.out.println(password1);
			}
			break;
		// view particular user id details
		case 5:

			System.out.println("Enter you id");
			int userid = sc.nextInt();

			ResultSet viewOneUser = userDao.viewOneUser(userid);

			while (viewOneUser.next()) {
				int id1 = viewOneUser.getInt(1);
				String name1 = viewOneUser.getString(2);
				String email1 = viewOneUser.getString(3);
				String password1 = viewOneUser.getString(4);
				System.out.println(id1);
				System.out.println(name1);
				System.out.println(email1);
				System.out.println(password1);
			}
			break;
		// view holidays list
		case 6:
			System.out.println("Enter your Name ");
			name = sc.next();
			System.out.println("Enter your Password");
			password = sc.next();

			if (userDao.userLogin(name, password)) {

			ResultSet leaveList=(ResultSet) userDao.leaveList();
				while (leaveList.next()) {
					System.out.println(leaveList.getInt(1));
					int listId = leaveList.getInt(1);
					String dates = leaveList.getString(2);
					String holidays = leaveList.getString(3);

				}
				}
			break;
				case 7:
					
					ResultSet leaveList=(ResultSet) userDao.leaveList();
					while (leaveList.next()) {
						int listId = leaveList.getInt(1);
						String dates = leaveList.getString(2);
						String holidays = leaveList.getString(3);
					
			}

			break;
		default:
			System.out.println("\nplease enter a valid option!");
		}
	}
}
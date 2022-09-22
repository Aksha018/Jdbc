package com.chainsys.main;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.chainsys.dao.TransactionDao;
import com.chainsys.dao.UserDao;
import com.chainsys.user.Transaction;

public class TransactionMain {
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		TransactionDao transactionDao = new TransactionDao();
		Transaction transaction = new Transaction();
		
		int transactionId;
		int userId;
		double indianRupees;
		double currency;
		

	    double amount=0;
	    double dollar, pound, euro;
	    DecimalFormat f = new DecimalFormat("##.##");
	 	
		System.out.println("Enter your Transaction Id");
		  transactionId = sc.nextInt();
		  transaction.setTransactionId(transactionId);
		 
		System.out.println("Enter your User Id");
		 userId = sc.nextInt();
		 transaction.setUserId(userId);
		
		 
		 System.out.println("Following are the Choices:");
		    System.out.println("Enter 1: Dollar");
		    System.out.println("Enter 2: Pound");
		    System.out.println("Enter 3: Euro");

		    System.out.print("\nChoose from above options: ");
		    int select = sc.nextInt();

		    System.out.println("Enter the amount you want to convert?");
		    amount = sc.nextFloat();
		    transaction.setIndianRupees(amount);
		    
		    
		    switch(select) { 
		    
	       case 1:  
		          dollar = amount / 70;
		          System.out.println(amount + " Rs = " + f.format(dollar) + " Dollar");
		         transaction.setCurrency(dollar);
		          break;
		   case 2:
		          pound = amount / 88;
		          System.out.println(amount + " Rs = " + f.format(pound) + " Pound");
		          transaction.setCurrency(pound);
		          break;
	       case 3:
		          euro = amount / 80;
		          System.out.println(amount + " Rs = " + f.format(euro) + " Euro");
		          transaction.setCurrency(euro);
		        break;
		          
		      default:
		          System.out.println("Invalid Input");
		 }
		 TransactionDao.insertUser(transaction);
		UserDao userDao= new UserDao();
		userDao.transaction(amount);
	}
	
}

	

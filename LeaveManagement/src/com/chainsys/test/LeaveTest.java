package com.chainsys.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.dao.LeaveDao;
import com.chainsys.dao.UserDao;
import com.chainsys.user.Leave;


public class LeaveTest {
	public static void main(String args[]) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		 int leaveId;
		 String leaveType;
	     String fromDate;
		 String toDate;
		 int noOfDays;
		 int id;
		 
		LeaveDao leaveDao = new LeaveDao();
		Leave leave=new Leave();
		 
		 System.out.println("Select Option:");
			System.out.println("Enter 1 for Apply Leave"+" \nEnter 2 for viewleave");
			int choose = sc.nextInt();
			switch(choose) {
	case 1:
		System.out.println("Enter your LeaveId");
		leaveId = sc.nextInt();
		leave.setLeaveId(leaveId);
		
		System.out.println("Enter your LeaveType");
		leaveType = sc.next();
		leave.setLeaveType(leaveType);
		
		
		System.out.println("Enter your From Date");
		fromDate = sc.next();
		leave.setFromDate(fromDate);
		
		
		System.out.println("Enter your ToDate");
		toDate = sc.next();
		leave.setToDate(toDate);
	
//		System.out.println("Enter your No Of Days");
//		noOfDays = sc.nextInt();
//		leave.setNoOfDays(noOfDays);
		
		System.out.println("Enter your Id");
		id = sc.nextInt();
		leave.setId(id);
		
		LeaveDao.applyLeave(leave);
break;
case 2:
	
	System.out.println("Enter your Name ");
	   String name= sc.next();
	System.out.println("Enter your Password");
	   String password= sc.next();
	   
	   if(leaveDao.adminLogin(name, password))
	   {
		   System.out.println("Enter Leave Id");
		     int leaveid = sc.nextInt();
		     ResultSet viewOneLeaveList = LeaveDao.viewOneLeaveList(leaveid);
		    // System.out.println(viewOneLeaveList);
	
		     //ResultSet viewLeaveList =LeaveDao.viewLeaveList();
		     
	while(viewOneLeaveList.next()) {
	 int leaveId1 = viewOneLeaveList.getInt(1);
	 String leaveType1 = viewOneLeaveList.getString(2);
     String fromDate1 = viewOneLeaveList.getString(3);;
	 String toDate1 = viewOneLeaveList.getString(4);;
	 int noOfDays1 = viewOneLeaveList.getInt(5);
	 int id1 = viewOneLeaveList.getInt(6);
	 
	 System.out.println(leaveId1);
	 System.out.println(leaveType1);
	 System.out.println(fromDate1);
	 System.out.println(toDate1);
	 System.out.println(noOfDays1);
	 System.out.println(id1);
	
	}
	}
			
	}

	}
}

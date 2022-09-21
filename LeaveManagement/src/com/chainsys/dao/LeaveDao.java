package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.chainsys.connectionutil.ConnUtil;
import com.chainsys.user.Leave;
import com.chainsys.user.User;

public class LeaveDao {
	public static void applyLeave(Leave leave) throws SQLException {
	
	Connection con = ConnUtil.getConnection();
	System.out.println(con);
	
	PreparedStatement al = con
			.prepareStatement("INSERT INTO LEAVE(LEAVE_ID,LEAVE_TYPE,FROM_DATE,TO_DATE,NO_OF_DAYS,ID) VALUES (?,?,?,?,?,?)");

	
	 try {
			// Convert String to Date
			    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			    java.util.Date fromDate1 = sdf.parse(leave.getFromDate());
			    java.util.Date toDate1 = sdf.parse(leave.getToDate());

			// Calculate the number of days between dates
			    long timeDiff = Math.abs(toDate1.getTime() - fromDate1.getTime());
			    int noOfDays = (int) TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
			    leave.setNoOfDays(noOfDays);
			    System.out.println("The number of days between dates: " + noOfDays);
			}catch(Exception e){
			    e.printStackTrace();
			}

	al.setInt(1,leave.getLeaveId());
	al.setString(2, leave.getLeaveType());
	al.setString(3, leave.getFromDate());
	al.setString(4, leave.getToDate());
	al.setInt(5,leave.getNoOfDays());
	al.setInt(6, leave.getId());
	
	int update = al.executeUpdate();
   System.out.println("inserted" + update);
   
   }
	
public boolean adminLogin(String name, String password) {
		
		if(name.equals("Admin")&&password.equals("admin123"))
		{
			return true;
		}
		else {
			return false;
		}	
}
	public static ResultSet viewLeaveList() throws SQLException {
		Connection connection = ConnUtil.getConnection();
		PreparedStatement lv = connection.prepareStatement("SELECT LEAVE_ID,LEAVE_TYPE,FROM_DATE,TO_DATE,NO_OF_DAYS,ID FROM LEAVE");
     
		ResultSet q = lv.executeQuery();
		
		System.out.println("leaveList" + q);
		
	    return q;

	}
	
	public static ResultSet viewOneLeaveList(int leaveId) throws SQLException {
		//System.out.println("hi");
		Connection connection = ConnUtil.getConnection();
		PreparedStatement vol = connection.prepareStatement("SELECT LEAVE_TYPE, FROM_DATE, TO_DATE, NO_OF_DAYS,ID FROM LEAVE WHERE LEAVE_ID =?");
     
		vol.setInt(1, 1 );
		ResultSet q = vol.executeQuery();
		while(q.next())
		{
		System.out.println("OneleaveList" + q.getInt(1));
		}
			System.out.println("invalid");
	    return q;
	}
	
}



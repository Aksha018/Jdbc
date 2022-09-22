package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.connectionutil.ConnectionUtil;
import com.chainsys.user.User;

public class UserDao {
	
	public void insertUser(User user) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO USERS(USERID,USERNAME,PASSWORD,BALANCE) VALUES (?,?,?,?)");

		ps.setInt(1, user.getUserId());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getBalance());

		int update = ps.executeUpdate();
		System.out.println("inserted" + update);
	}
	
	public void updateUser(User user) throws SQLException {

Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ps = connection
				.prepareStatement("UPDATE USERS SET USERNAME=?,PASSWORD=?,BALANCE=? WHERE USERID=?");

		
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setInt(3,user.getBalance());
		ps.setInt(4, user.getUserId());
		
		
		int update = ps.executeUpdate();
		System.out.println("updated" + update);
	}
	
	public void deleteUser(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM USERS WHERE USERID=?");

		ps.setInt(1, id);
		int update = ps.executeUpdate();
		System.out.println("deleted" + update);
	}
	public static ResultSet listUser() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS");

		ResultSet query = ps.executeQuery();

		System.out.println("ListUser" + query);
		return query;

	}
	
	public static ResultSet registerdUser(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT USERID,USERNAME,PASSWORD,BALANCE FROM USERS WHERE USERID=?");

		ps.setInt(1, id);
		ResultSet query = ps.executeQuery();

		System.out.println("RegisterdUser" + query);
		return query;

	}
	
	public static int getSenderbalance() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE USERID=100");

		ResultSet query = ps.executeQuery();
		int balance = 0;
		
		while(query.next()){
          balance = query.getInt("balance");
		}
		System.out.println("getSenderbalance" + query);
		return balance;
		

}
	
	public static int getReceiverbalance() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE USERID=101");

		ResultSet query = ps.executeQuery();
		int balance = 0;
		while(query.next()) {
          balance = query.getInt("balance");
		}
		System.out.println("getReceiverbalance" + query);
		return balance;
	}

	public static void updateSenderBalance(int balance) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
				
				PreparedStatement ps = connection
						.prepareStatement("UPDATE USERS SET BALANCE=? WHERE USERID=100");

				
                ps.setInt(1,balance);
				
				int update = ps.executeUpdate();
				System.out.println("Balance updated" + update);
			}
	public static void updateReceiverBalance(int balance) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
				
				PreparedStatement ps = connection
						.prepareStatement("UPDATE USERS SET BALANCE=? WHERE USERID=101");

				
                ps.setInt(1,balance);
				
				int update = ps.executeUpdate();
				System.out.println("Balance updated" + update);
			}
	
public void transaction(double transactionAmount) throws SQLException {
		
		int getSenderbalance = getSenderbalance();
		double senderBalance = getSenderbalance - transactionAmount ;
		int getReceiverbalance = getReceiverbalance();
		double receiverBalance = getReceiverbalance + transactionAmount;
	    updateSenderBalance(getSenderbalance);
	    updateReceiverBalance(getReceiverbalance);
	}
	
}

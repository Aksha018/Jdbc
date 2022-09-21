package com.chainsys.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.connectionutil.ConnUtil;
import com.chainsys.user.Holiday;

public class Testholidays {
	public static void main(String args[]) throws SQLException {
		leaveList();

	}

	public static ResultSet leaveList() throws SQLException {

		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT list_id,holidays FROM LeaveList ");

		ResultSet query = ps.executeQuery();
		
		while (query.next()) {
			String holidays = query.getString(3);
			System.out.println(holidays);
			System.out.println("leaveList" + query.getString("holidays"));
		}
		return query;
	}
}
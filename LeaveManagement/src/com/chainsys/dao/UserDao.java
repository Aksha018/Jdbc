package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.connectionutil.ConnUtil;
import com.chainsys.user.User;

public class UserDao {
	public void saveUser(User user) throws SQLException {

		Connection connection = ConnUtil.getConnection();
		// System.out.println(connection);
		// query, ps,executequery
		PreparedStatement ps = connection
				.prepareStatement("insert into user1(Id,name,email,password) values (?,?,?,?)");

		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());

		int update = ps.executeUpdate();
		System.out.println("inserted" + update);
	}

	public void updateUser(User user) throws SQLException {

		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("update user1 set name=?,email=?,password=? where id=?");

		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getId());

		int update = ps.executeUpdate();
		System.out.println("updated" + update);
	}

	public void deleteUser(int id) throws SQLException {
		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("Delete from user1 where id=?");

		ps.setInt(1, id);
		int update = ps.executeUpdate();
		System.out.println("deleted" + update);
	}

	public static ResultSet viewUser() throws SQLException {
		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT id ,name, email, password FROM USER1");

		ResultSet query = ps.executeQuery();

		System.out.println("viewUser" + query);
		return query;

	}

	public static ResultSet viewOneUser(int id) throws SQLException {
		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT id ,name, email, password FROM USER1 where id=?");

		ps.setInt(1, id);
		ResultSet query = ps.executeQuery();

		System.out.println("viewOneUser" + query);
		return query;

	}

	public boolean userLogin(String name, String password) {

		if (name.equals("Gowri") && password.equals("asdfghj")) {
			return true;
		} else {
			return false;
		}
	}

	public Set leaveList() throws SQLException {
		Connection connection = ConnUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT list_id, dates,holidays FROM LeaveList ");

		ResultSet query = ps.executeQuery();
		return (Set) query;

		// System.out.println("LeaveList" + query);

	}
}

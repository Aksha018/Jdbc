package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.chainsys.connectionutil.ConnectionUtil;
import com.chainsys.user.Transaction;

public class TransactionDao {
	
	public static void insertUser(Transaction transaction) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO TRANSACTION(TRANSACTION_ID,USERID,RECEIVER_ID,INDIAN_RUPEES,CURRENCY) VALUES (?,?,?,?,?)");
		ps.setInt(1, transaction.getTransactionId());
		ps.setInt(2, transaction.getUserId());
		ps.setInt(3, transaction.getReceiverId());
		ps.setDouble(4, transaction.getIndianRupees());
		ps.setDouble(5, transaction.getCurrency());

		int update = ps.executeUpdate();
		System.out.println("inserted" + update);
		
	}
	
}


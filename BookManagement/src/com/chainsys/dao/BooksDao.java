package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.connectionUtil.ConnUtil;
import com.chainsys.model.Books;


public class BooksDao {
	public void saveBooks(Books book) throws SQLException{
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("Insert into BOOKS(BOOK_ID,BOOK_NAME,AUTHOR,PRICE,SELLING_DATE,PUBLISHING_YEAR)values(?,?,?,?,?,?)");
		
		ps.setInt(1,book.getBookId());
		ps.setString(2, book.getBookName());
		ps.setString(3, book.getAuthor());
		ps.setInt(4, book.getPrice());
		ps.setDate(5,book.getSellingDate());
		ps.setString(6,book.getPublishingYear());
		
		int update = ps.executeUpdate();
		System.out.println("inserted"+update);
	}
	
	public void updateBook(Books book) throws SQLException {

		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("update BOOKS set BOOK_NAME=?,AUTHOR=?,PRICE=?,SELLING_DATE=?,PUBLISHING_YEAR=? where BOOK_ID=?");

		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setInt(3, book.getPrice());
		ps.setDate(4,book.getSellingDate());
		ps.setString(5,book.getPublishingYear());
		ps.setInt(6,book.getBookId());
		
		int update = ps.executeUpdate();
		System.out.println("updated"+update);
	}

	public void deleteBook(int bookId) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("Delete from BOOKS where BOOK_ID=?");

		ps.setInt(1, bookId);
		int update = ps.executeUpdate();
		System.out.println("deleted" + update);
	}

	public static ResultSet viewBooks() throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOKS");

		ResultSet query = ps.executeQuery();

		System.out.println("viewBooks" + query);
		return query;

	}
	
	public static ResultSet findByBookNames(String bookName) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOKS where BOOK_NAME=?");

		ps.setString(1, bookName);
		ResultSet query = ps.executeQuery();

		System.out.println("viewBookNames" + query);
		return query;

	}
	
	public static ResultSet findById(int bookId) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOKS where BOOK_ID=?");
		ps.setInt(1, bookId);
		ResultSet query = ps.executeQuery();
		System.out.println("findById" + query);
		return query;

    }
	public static ResultSet findByAuthor(String author) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOKS where AUTHOR=?");

		ps.setString(1, author);
		ResultSet query = ps.executeQuery();

		System.out.println("viewBookNames" + query);
		return query;

	}
	public static ResultSet findByYearOfPublishing(String publishingYear) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOKS where PUBLISHING_YEAR=?");

		ps.setString(1, publishingYear);
		ResultSet query = ps.executeQuery();

		System.out.println("viewBookNames" + query);
		return query;

	}
}

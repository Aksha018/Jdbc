package com.chainsys.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.chainsys.dao.BooksDao;
import com.chainsys.model.Books;
 

public class BookTest {
	public static void main(String args[]) throws SQLException {

		Scanner sc = new Scanner(System.in);
		
		int bookId = 0,price;
		String bookName,author,publishingYear;
		
		BooksDao bookDao = new BooksDao();
		Books book = new Books();
		System.out.println("Select Option:");
		System.out.println("Enter 1 for Insert" + "\nEnter 2 for Update" + "\nEnter 3 for delete" + "\nEnter 4 for view"+"\nEnter 5 to find the name of the book"
		+"\nEnter 6 to find the book id"+"\nEnter 7 to find the Author Name"+"\nEnter 8 to find year of publishing");
		int choice = sc.nextInt();
		switch (choice) {
		
//		add user
		case 1:
			System.out.println("Enter Book Id");
			bookId = sc.nextInt();
			book.setBookId(bookId);

			System.out.println("Enter Book Name");
			bookName = sc.next();
			book.setBookName(bookName);

			System.out.println("Enter Author of the Book");
			author = sc.next();
			book.setAuthor(author);

			System.out.println("Enter Price of the Book");
			price = sc.nextInt();
			book.setPrice(price);
			
			 System.out.println("Enter Year Of Pubishing");
			 publishingYear = sc.next();
			 book.setPublishingYear(publishingYear);
			 
		    long millis=System.currentTimeMillis();  
	        java.sql.Date sellingDate=new java.sql.Date(millis);      
			 book.setSellingDate(sellingDate);
			 System.out.println("Date of Selling :"+sellingDate);
			 
			

			bookDao.saveBooks(book);
			
			break;
//		update user 
		case 2:
			System.out.println("Enter Book Id");
			bookId = sc.nextInt();
			book.setBookId(bookId);

			System.out.println("Enter Book Name");
			bookName = sc.next();
			book.setBookName(bookName);

			System.out.println("Enter Author of the Book");
			author = sc.next();
			book.setAuthor(author);
			
			System.out.println("Enter Year Of Pubishing");
			 publishingYear = sc.next();
			 book.setPublishingYear(publishingYear);

			System.out.println("Enter Price of the Book");
			price = sc.nextInt();
			book.setPrice(price);
			
			long date=System.currentTimeMillis();  
	        java.sql.Date sellingDate1=new java.sql.Date(date);      
			 book.setSellingDate(sellingDate1);
			 System.out.println("Date of Selling :"+sellingDate1);
				
			bookDao.updateBook(book);
			
			break;
//	    delete user
		case 3:
			System.out.println("Enter Book Id");
			bookId = sc.nextInt();
			book.setBookId(bookId);

			bookDao.deleteBook(bookId);
			break;
//    view user
		case 4:

			ResultSet viewBooks = bookDao.viewBooks();
			while (viewBooks.next()) {
				int bookId1 = viewBooks.getInt(1);
				String bookName1 = viewBooks.getString(2);
				String author1 = viewBooks.getString(3);
				int price1 = viewBooks.getInt(4);
				String publishingYear1 = viewBooks.getString(5);
				System.out.println("Book Id : "+bookId1);
				System.out.println("Book Name :"+bookName1);
				System.out.println("Author :"+author1);
				System.out.println("Price :"+price1);
				System.out.println("Publishing Year :"+publishingYear1);
				
			}
//Find by BookName			
		case 5:
			
			System.out.println("Enter Book Name");
			bookName = sc.next();

			ResultSet booksNames = bookDao.findByBookNames(bookName);
			
			while (booksNames.next()) {
				int bookId1 = booksNames.getInt(1);
				String bookName1 = booksNames.getString(2);
				String author1 = booksNames.getString(3);
				int price1 = booksNames.getInt(4);
				String publishingYear1 = booksNames.getString(5);
				System.out.println("Book Id : "+bookId1);
				System.out.println("Book Name :"+bookName1);
				System.out.println("Author :"+author1);
				System.out.println("Price :"+price1);
				System.out.println("Publishing Year :"+publishingYear1);
			}
//Find by BookId			
		case 6:
			System.out.println("Enter Book Id");
			bookId = sc.nextInt();
			
			ResultSet findBookId = bookDao.findById(bookId);
			
			while (findBookId.next()) {
				int bookId1 = findBookId.getInt(1);
				String bookName1 = findBookId.getString(2);
				String author1 = findBookId.getString(3);
				int price1 = findBookId.getInt(4);
				String publishingYear1 = findBookId.getString(5);
				
				System.out.println("Book Id : "+bookId1);
				System.out.println("Book Name :"+bookName1);
				System.out.println("Author :"+author1);
				System.out.println("Price :"+price1);
				System.out.println("Publishing Year :"+publishingYear1);
			}
		case 7:
			System.out.println("Enter Author of the Book");
			author = sc.next();
			book.setAuthor(author);
			
			ResultSet findAuthor = bookDao.findByAuthor(author);
			
			while (findAuthor.next()) {
				int bookId1 = findAuthor.getInt(1);
				String bookName1 = findAuthor.getString(2);
				String author1 = findAuthor.getString(3);
				int price1 = findAuthor.getInt(4);
				String publishingYear1 = findAuthor.getString(5);
				
				System.out.println("Book Id : "+bookId1);
				System.out.println("Book Name :"+bookName1);
				System.out.println("Author :"+author1);
				System.out.println("Price :"+price1);
				System.out.println("Publishing Year :"+publishingYear1);
			}
		case 8:
		
			 System.out.println("Enter Year Of Pubishing");
			 publishingYear = sc.next();
			 book.setPublishingYear(publishingYear);
			 
			ResultSet findPublishingYear = bookDao.findByYearOfPublishing(publishingYear);
			
			while (findPublishingYear.next()) {
				int bookId1 = findPublishingYear.getInt(1);
				String bookName1 = findPublishingYear.getString(2);
				String author1 = findPublishingYear.getString(3);
				int price1 = findPublishingYear.getInt(4);
				String publishingYear1 = findPublishingYear.getString(5);
				
				System.out.println("Book Id : "+bookId1);
				System.out.println("Book Name :"+bookName1);
				System.out.println("Author :"+author1);
				System.out.println("Price :"+price1);
				System.out.println("Publishing Year :"+publishingYear1);
			}
			
			break;
		default:
			System.out.println("\nplease enter a valid option!");
		}
		sc.close();
	}
}

package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Books;

/**
 * The LibraryDao class manages database operations related to Books.
 * @author Jhansi Saranu , Sunitha Thota , Venkata Mani Krishna Lam , Sree Harsha Guntamadugu.
 */
public class LibraryDao {
	
	/**
	 * Establishes a database connection.
	 * @return Connection object representing the database connection
	 */
	public Connection setupConnection() {
		Connection connection = null;
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/library";
		try {
			connection = DriverManager.getConnection(url, user, password);
			//System.out.println("Connection established successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * Retrieves and displays all records of Books.
	 * @return List of Books retrieved
	 */
	public List<Books> displayRecords() {
		List<Books> booksList = new ArrayList<>();
		Connection connection = setupConnection();
		String sqlQuery = "SELECT * FROM books";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Books book = new Books(resultSet.getInt("bookid"), resultSet.getString("bookname"),
						resultSet.getString("authorname"), resultSet.getString("category"),
						resultSet.getString("publisher"), resultSet.getString("price"));
				booksList.add(book);
			}
			System.out.println("Records retrieved: " + booksList.size());
			System.out.println(booksList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return booksList;
	}
	
	/**
	 * Inserts a record of Book into the database.
	 * @param book The Book object to be inserted
	 */
	public void insertRecord(Books book) {
		Connection connection = setupConnection();
		String sqlQuery = "INSERT INTO books (bookid, bookname, authorname, category, publisher, price) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, book.getBookID());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setString(4, book.getCategory());
			preparedStatement.setString(5, book.getPublisher());
			preparedStatement.setString(6, book.getPrice());
			int status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record inserted successfully!");
				displayRecords();
			} else {
				System.out.println("Failed to insert record. Please try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieves a record of Book by its ID from the database.
	 * @param bookID The ID of the Book to retrieve
	 * @return The Book object retrieved
	 */
	public Books getRecordById(int bookID) {
		Books book = null;
		Connection connection = setupConnection();
		String sqlQuery = "SELECT * FROM books WHERE bookid=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, bookID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book = new Books(resultSet.getInt("bookid"), resultSet.getString("bookname"),
						resultSet.getString("authorname"), resultSet.getString("category"),
						resultSet.getString("publisher"), resultSet.getString("price"));
			}
			System.out.println("Record retrieved: " + book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	/**
	 * Deletes a record of Book by its ID from the database.
	 * @param bookID The ID of the Book to delete
	 */
	public void deleteRecordById(int bookID) {
		Connection connection = setupConnection();
		String sqlQuery = "DELETE FROM books WHERE bookid=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, bookID);
			int status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record deleted successfully!");
				displayRecords();
			} else {
				System.out.println("Failed to delete record. Please try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates a record of Book by its ID in the database.
	 * @param currentID The current ID of the Book
	 * @param updatedBook The updated Book object
	 */
	public void updateRecordById(int currentID, Books updatedBook) {
		Connection connection = setupConnection();
		String sqlQuery = "UPDATE books SET bookid=?, bookname=?, authorname=?, category=?, publisher=?, price=? WHERE bookid=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, updatedBook.getBookID());
			preparedStatement.setString(2, updatedBook.getBookName());
			preparedStatement.setString(3, updatedBook.getAuthorName());
			preparedStatement.setString(4, updatedBook.getCategory());
			preparedStatement.setString(5, updatedBook.getPublisher());
			preparedStatement.setString(6, updatedBook.getPrice());
			preparedStatement.setInt(7, currentID);
			int status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record updated successfully!");
				displayRecords();
			} else {
				System.out.println("Failed to update record. Please try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

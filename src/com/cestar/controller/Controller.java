package com.cestar.controller;

import java.util.Scanner;

import com.cestar.dao.LibraryDao;
import com.cestar.model.Books;

/**
 * The Controller class manages user input and interacts with the DAO to perform CRUD operations on Books.
 * @author Jhansi Saranu , Sunitha Thota , Venkata Mani Krishna Lam , Sree Harsha Guntamadugu.
 */
public class Controller {
	
	private final LibraryDao dao;
	private final Scanner scanner;
	
	/**
	 * Constructs a new Controller object with default values.
	 */
	public Controller() {
		dao = new LibraryDao();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Displays all records of Books.
	 */
	public void display() {
		System.out.println("==========================================================");
		System.out.println("=================Displaying all records option=========");
		System.out.println("==========================================================");
		 
		System.out.println("------------------------------------------------------------");
		dao.displayRecords();
		System.out.println("---------------------------------------------------------------");
	}
	
	/**
	 * Inserts a new record of a Book.
	 */
	public void insert() { 
		System.out.println("==========================================================");
		System.out.println("=================Inserting records option=========");
		System.out.println("==========================================================");
		
		System.out.println("Please Enter the ID of the Book to Insert Record : =>");
		int bookID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Please Enter the Name of the Book to Insert Record : =>");
		String bookName = scanner.nextLine();
		
		System.out.println("Please Enter the Name of the Author to Insert Record : =>");
		String authorName = scanner.nextLine();
		
		System.out.println("Please Enter the Category of the Book to Insert Record : =>");
		String category = scanner.nextLine();
		
		System.out.println("Please Enter the Publisher Name of the Book to Insert Record : =>");
		String publisher = scanner.nextLine();
		
		System.out.println("Please Enter the Price of the Book to Insert Record : =>");
		String price = scanner.nextLine();
		
		Books book = new Books(bookID, bookName, authorName, category, publisher, price);
		
		System.out.println("------------------------------------------------------------");
		dao.insertRecord(book);
		System.out.println("---------------------------------------------------------------");
	}
	
	/**
	 * Deletes a record of a Book.
	 */
	public void delete() {
		System.out.println("==========================================================");
		System.out.println("=================Deleting records option=========");
		System.out.println("==========================================================");
		
		System.out.println("Please Enter the ID of the Book to Delete Record : =>");
		int bookID = scanner.nextInt();
		
		System.out.println("------------------------------------------------------------");
		dao.deleteRecordById(bookID);
		System.out.println("---------------------------------------------------------------");
	}
	
	/**
	 * Finds a record of a Book by its ID.
	 */
	public void findById() {
		System.out.println("====================================================================");
		System.out.println("=================Finding Record By ID option in our Application  =========");
		System.out.println("=====================================================================");
		
		System.out.println("Please enter the ID of the Book to Fetch Record :=>");
		int idToFetchRecord = scanner.nextInt();
		
		dao.getRecordById(idToFetchRecord);
	}
	
	/**
	 * Updates a record of a Book by its ID.
	 */
	public void updateById() {
		System.out.println("==========================================================================");
		System.out.println("=================Updating Record By ID option in our Application  =========");
		System.out.println("===========================================================================");
		
		System.out.println("Please Enter the ID of the Book to Update Record : =>");
		int bookID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Please Enter the Name of the Book to Update Record : =>");
		String bookName = scanner.nextLine();
		
		System.out.println("Please Enter the Name of the Author to Update Record : =>");
		String authorName = scanner.nextLine();
		
		System.out.println("Please Enter the Category of the Book to Update Record : =>");
		String category = scanner.nextLine();
		
		System.out.println("Please Enter the Publisher Name of the Book to Update Record : =>");
		String publisher = scanner.nextLine();
		
		System.out.println("Please Enter the Price of the Book to Update Record : =>");
		String price = scanner.nextLine();
		
		Books book = new Books(bookID, bookName, authorName, category, publisher, price);
		
		System.out.println("------------------------------------------------------------");
		dao.updateRecordById(bookID, book);
		System.out.println("---------------------------------------------------------------");		
	}
}

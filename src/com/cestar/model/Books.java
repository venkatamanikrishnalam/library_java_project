package com.cestar.model;

/**
 * The {@code Book} class represents a book entity with various properties such as ID, name, author, category, publisher, and price.
 * It provides methods to access and manipulate these properties.
 * @author Jhansi Saranu , Sunitha Thota , Venkata Mani Krishna Lam , Sree Harsha Guntamadugu
 * @version 1.0
 * @since 2024-04-06
 */
public class Books {
	
	private int bookID;
	private String bookName;
	private String authorName;
	private String category;
	private String publisher;
	private String price;
	
	/**
     * Constructs a new book with default values.
     */
	public Books() {
		super();
	}
	
	/**
     * Constructs a new book with the specified details.
     *
     * @param bookID The unique identifier of the book
     * @param bookName The name of the book
     * @param authorName The name of the author of the book
     * @param category The category of the book
     * @param publisher The publisher of the book
     * @param price The price of the book
     */
	public Books(int bookID, String bookName, String authorName, String category, String publisher, String price) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
		this.category = category;
		this.publisher = publisher;
		this.price = price;
	}
	
	/**
     * Returns the unique identifier of the book.
     *
     * @return The unique identifier of the book
     */
	public int getBookID() {
		return bookID;
	}
	
	/**
     * Sets the unique identifier of the book.
     *
     * @param bookID The unique identifier of the book
     */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	/**
     * Returns the name of the book.
     *
     * @return The name of the book
     */
	public String getBookName() {
		return bookName;
	}
	
	/**
     * Sets the name of the book.
     *
     * @param bookName The name of the book
     */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	/**
     * Returns the name of the author of the book.
     *
     * @return The name of the author of the book
     */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
     * Sets the name of the author of the book.
     *
     * @param authorName The name of the author of the book
     */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	/**
     * Returns the category of the book.
     *
     * @return The category of the book
     */
	public String getCategory() {
		return category;
	}
	
	/**
     * Sets the category of the book.
     *
     * @param category The category of the book
     */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
     * Returns the publisher of the book.
     *
     * @return The publisher of the book
     */
	public String getPublisher() {
		return publisher;
	}
	
	/**
     * Sets the publisher of the book.
     *
     * @param publisher The publisher of the book
     */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
     * Returns the price of the book.
     *
     * @return The price of the book
     */
	public String getPrice() {
		return price;
	}
	
	/**
     * Sets the price of the book.
     *
     * @param price The price of the book
     */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
     * Returns a string representation of the book.
     *
     * @return A string representation of the book
     */
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", authorName=" + authorName + ", category="
				+ category + ", publisher=" + publisher + ", price=" + price + "]\n";
	}

}

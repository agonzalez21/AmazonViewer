package com.platzi.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Redaccion{
	
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	
	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public boolean isReaded() {
		return readed;
	}
	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	public int getTimeReaded() {
		return timeReaded;
	}
	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	public Book(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial, authors);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Book> makeBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		return books;
	}	
	
}

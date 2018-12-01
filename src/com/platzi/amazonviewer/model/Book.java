package com.platzi.amazonviewer.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Book extends Redaccion implements IVisualizable{

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

		for (int index = 0; index <= 5; index++) {
			int year = 2003+index;
			int month = 12;
			int day = 12;
			String date = year + "/" + month +"/" + day;
			java.util.Date utilDate=null;


			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				utilDate = formatter.parse(date);
			} catch (Exception e) {
				// TODO: handle exception
			}

			books.add(new Book("Book"+index,utilDate,"Editorial"+index,new String[1]));
		}

		return books;
	}

	public void view() {
		setReaded(true);

		Date dateStar = startToSee(new Date());

		for (int i = 0; i < 10000; i++) {
			System.out.println("Viewing ...");
		}

		stopToSee(dateStar, new Date());
		System.out.println("");
		System.out.println("Leiste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
	}

}

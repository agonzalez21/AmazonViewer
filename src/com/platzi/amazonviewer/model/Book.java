package com.platzi.amazonviewer.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Book extends Redaccion implements IVisualizable{

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
    private ArrayList<Page> pages;
	
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

	public ArrayList<Page> getPages() {
		return pages;
	}
	
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> pPages) {
		super(title, editionDate, editorial, authors);
		setAuthors(authors);
		this.pages = pPages;
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

			ArrayList<Page> pages = new ArrayList<Page>();
			int numeroPagina = 0;
			for (int i = 0; i < 3; i++) {
				numeroPagina = i+1;
				pages.add(new Book.Page(numeroPagina, "El contenido de la pagina " + numeroPagina));
			}
			
			books.add(new Book("Book"+index,utilDate,"Editorial"+index,new String[1], pages));
		}

		return books;
	}

	public void view() {
		setReaded(true);
		Date dateStar = startToSee(new Date());

		int index=0;
		do {
			
			System.out.println("........");
			System.out.println("Page " + getPages().get(index).getNumber());
			System.out.println(getPages().get(index).getContent());
			System.out.println("........");
			if (index!=0) {
				System.out.println("1. Regresar página.");
			}
			System.out.println("2. Siguiente página.");
			System.out.println("0. Cerrar libro.");
			System.out.println();
			
			Scanner sc = new Scanner(System.in);
			int response = Byte.valueOf(sc.nextLine());
			
			if (response == 0) 
				break;
			
			if (response == 1)
				index--;
			
			if (response == 2) 
				index++;
		
		} while (index<getPages().size());

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


	public static class Page
	{
		private int id;
		private int number;
		private String content;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
	}
	
}

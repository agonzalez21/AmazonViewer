package com.platzi.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;
	
	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
	}

	public static ArrayList<Serie> makeSeries(){
		ArrayList<Serie> series = new ArrayList<Serie>();
		
		for (int index = 0; index <= 5; index++) {
			series.add(new Serie("Serie " + index, "Genero "+index,"Creator "+index, (short)(2018+index),index));
		}
		
		return series;
	}
	
	@Override
	public String toString() {
		return "\n Serie"+
				"\n Title: " + getTitle() + 
				"\n Genere: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
	}
	
}

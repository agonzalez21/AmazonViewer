package com.platzi.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	public Serie(String title, String genre, String creator, int duration) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Serie> makeSeries(){
		ArrayList<Serie> series = new ArrayList<Serie>();
		
		for (int index = 0; index <= 5; index++) {
			series.add(new Serie("Serie " + index, "Genero "+index,"Creator "+index, (short)(2018+index)));
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
	
}

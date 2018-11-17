package com.platzi.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase movie que contiene las propiedades de una
 * película.
 */
public class Movie extends Film implements IVisualizable {

	private int timeViewed;

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		this.year = year;
	}

	public static ArrayList<Movie> makeMovies(){
		ArrayList<Movie> movies = new ArrayList<Movie>();

		for (int index = 0; index <= 5; index++) {
			movies.add(new Movie("Movie "+ index, "Genero "+index, "Creator"+index,120+index,(short)(2017+index)));
		}

		return movies;
	}

	@Override
	public String toString() {
		return "\n MOVIE"+
				"\n Title: " + getTitle() + 
				"\n Genere: " + getGenre() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime()>dateI.getTime())
			setTimeViewed((int)(dateF.getTime()-dateI.getTime()));
		else
			setTimeViewed(0);
	}

}

package com.platzi.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.platzi.amazonviewer.dao.IMovieDAO;

/**
 * Hereda de {@link Film}.
 * Impleenta de {@link IVisualizable}
 */
public class Movie extends Film implements IVisualizable, IMovieDAO {

	private int timeViewed;

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		this.year = year;
	}

	public static ArrayList<Movie> makeMovies(){
		
		Movie movie = new Movie();
		return movie.read();
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

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime()>dateI.getTime())
			setTimeViewed((int)(dateF.getTime()-dateI.getTime()));
		else
			setTimeViewed(0);
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		setViewed(true);
		Date dateStar = startToSee(new Date());

		for (int i = 0; i < 10000; i++) {
			System.out.println("Viewing ...");
		}

		stopToSee(dateStar, new Date());
		System.out.println("");
		System.out.println("Viste: " + toString());
		System.out.println("Por: "+getTimeViewed() + " milisegundos");
	}

}

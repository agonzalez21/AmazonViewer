package com.platzi.amazonviewer.model;

import java.util.ArrayList;

/**
 * Herda de {@link Movie}
 * @see Film 
 * */
public class Chapter extends Movie {

	private int id;
	private int sessionNumber;
	private Serie serie;
	
	public int getId() {
		return id;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		// TODO Auto-generated constructor stub
		super(title,genre,creator,duration,year);
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}
	
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
		}
		
		return chapters;
}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if(chapter.getViewed())
				chapterViewedCounter++;
			getSerie().setViewed(chapterViewedCounter ==chapters.size());
		}
				
	}
	
}

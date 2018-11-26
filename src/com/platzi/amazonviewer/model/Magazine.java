package com.platzi.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Redaccion {

	public Magazine(String title, Date editionDate, String editorial, String[] authors) {
		// TODO Auto-generated constructor stub
		super(title,editionDate,editorial,authors);
	}
	
	public static ArrayList<Magazine> makeMagazines() {
		ArrayList<Magazine> movies = new ArrayList<Magazine>();

		for (int index = 0; index <= 5; index++) {
			Date fecha = new Date(2010+index,index,index);	
			String [] authors = new String[1];
			movies.add(new Magazine("Magazine"+index,fecha,"Editorial"+index,authors));
		}
		return movies;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n MOVIE"+
		"\n Title: " + getTitle() + 
		"\n Edition Date: " + getEditionDate();
	}
	
}

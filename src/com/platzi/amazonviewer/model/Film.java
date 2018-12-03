package com.platzi.amazonviewer.model;

/**
 * <h1>Film</h1>
 * Film es una clase abastracta.
 * <p>
 * Clase abastracta de la familia films. 
 * Contiene el método 
 * {@code view()} que es obligario implementar.
 * 
 * @author Alberto González Balderas
 * @version 1.0
 * @since 2018
 * */
public abstract class Film {
	
	protected int id;

	protected String title;
	protected String genre;
	protected String creator;
	protected int duration;
	protected short year;
	protected boolean viewed;
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	
	public Film() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public boolean getViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * {@code view()} Método obligario de implementar.
	 * */
	public abstract void view();
}

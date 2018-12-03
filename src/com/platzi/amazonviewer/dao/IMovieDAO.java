package com.platzi.amazonviewer.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.platzi.amazonviewer.db.DataBase.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.platzi.amazonviewer.db.IDBConnection;
import com.platzi.amazonviewer.model.Movie;

public interface IMovieDAO extends IDBConnection{
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	} 
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<>();
		try(Connection connection = connectToDB()){
			String query = "SELECT * FROM " + TMOVIE;
			PreparedStatement prearedStatment = connection.prepareStatement(query);
			ResultSet result = prearedStatment.executeQuery();
			
			while (result.next()) {
				Movie movie = new Movie(
						result.getString(TMOVIETITLE), 
						result.getString(TMOVIEGENRE), 
						result.getString(TMOVIECREATOR), 
						Integer.valueOf(result.getString( TMOVIEDURATION)),
						//0,
						//(short)0);
						Short.valueOf(result.getString(TMOVIEYEAR)));
						
						
				movie.setId(result.getInt(TMOVIEID));
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	private boolean getMovieViewed() {
		return false;
	}
	
}

package com.platzi.amazonviewer.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static com.platzi.amazonviewer.db.DataBase.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.platzi.amazonviewer.db.IDBConnection;
import com.platzi.amazonviewer.model.Movie;

public interface IMovieDAO extends IDBConnection{

	default Movie setMovieViewed(Movie movie) {

		try(Connection connection = connectToDB()) {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + TVIEWED + " ("+TVIEWEDIDMATERIAL+", " + TVIEWEDIDELEMENT+", "+TVIEWEDIDUSUARIO+")" + 
					" VALUES("+ID_TMATERIALS[0]+", "+movie.getId()+", "+TUSER_IDUSUARIO+")";
			if(statement.executeUpdate(query)>0)
				System.out.println("Se marcó en visto.");


		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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
				movie.setViewed(getMovieViewed(prearedStatment, connection, result.getInt(TMOVIEID)));
				movies.add(movie);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}

	private boolean getMovieViewed(PreparedStatement pPreparedStatement, Connection pConnection, int pMovieId) {
		boolean viewed = false;
		String query = "SELECT * FROM " + TVIEWED +
				" WHERE " + TVIEWEDIDMATERIAL + "= ?"+
				" AND " + TVIEWEDIDELEMENT + "= ?" +
				" AND " + TVIEWEDIDUSUARIO + "= ?";
		ResultSet rs = null;

		try {
			pPreparedStatement = pConnection.prepareStatement(query);
			pPreparedStatement.setInt(1,ID_TMATERIALS[0]);
			pPreparedStatement.setInt(2, pMovieId);
			pPreparedStatement.setInt(3, TUSER_IDUSUARIO);

			rs = pPreparedStatement.executeQuery();
			viewed = rs.next();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return viewed;
	}

}

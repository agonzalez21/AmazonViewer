package com.platzi.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.platzi.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB()
	{
		java.sql.Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
			if (connection!=null) 
				System.out.println("Se estableció la conexión.");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// TODO: handle finally clause
			return connection;
		}
	}

}

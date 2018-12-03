package com.platzi.amazonviewer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.platzi.amazonviewer.model.Book;
import com.platzi.amazonviewer.model.Chapter;
import com.platzi.amazonviewer.model.Film;
import com.platzi.amazonviewer.model.Magazine;
import com.platzi.amazonviewer.model.Movie;
import com.platzi.amazonviewer.model.Serie;

/**
 * <h1>AmazonViewer</h1>
 * Programa que permite visualizar Movies, Series cons sus respectivos Chapters
 * , Books y Magazines. Te permite generar reportes generales y con fecha del día.
 * <p>
 * Existen algunas reglas como que todos los elementos son visualizables.
 * 
 * @author Alberto González Balderas
 * @version 1.0
 * @since 2018
 */
public class Main {

	static java.sql.SQLException excepction = new java.sql.SQLException();
	static ArrayList<Movie> movies = Movie.makeMovies();
	static ArrayList<Serie> series;// = Serie.makeSeries();
	static ArrayList<Book> books;// = Book.makeBooks();
	static ArrayList<Magazine> magazines; //= Magazine.makeMagazines();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = excepction.toString();
		System.out.println("Mensaje: " +message);
		showMenu();
	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		byte option = (byte)(0);
		Scanner sc;

		do {
			System.out.println("-- Welcome to AmazonViewer! --");
			System.out.println("-- Menï¿½: --");
			System.out.println("1.Movies.");
			System.out.println("2.Series.");
			System.out.println("3.Books.");
			System.out.println("4.Magazines.");
			System.out.println("5.Reporte.");
			System.out.println("0.Exit.");
			sc = new Scanner(System.in);
			option = Byte.valueOf(sc.nextLine());
			//sc.close();

			switch (option) {
			case 1:
				Main.showMovies();
				break;

			case 2:
				Main.showSeries();
				break;

			case 3:
				Main.showBooks();
				break;

			case 4:
				Main.showMagazines();
				break;

			default:
				break;
			}

		} while (option!=0);
	}

	private static void showMagazines() {
		System.out.println("-- Cataloge of Magazines --");
		byte opcion = (byte)(0);
		do {

			System.out.println("\n --- Select your magazine: ---");
			for (int index = 0; index < magazines.size(); index++) {
				System.out.println((index+1)+magazines.get(index).getTitle() + " "+magazines.get(index).getEditionDate()+magazines.get(index).getEditorial());
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;

			if(opcion>0) {

				Magazine magazineSelected = magazines.get(opcion-1);
				System.out.println(magazineSelected);
				//Date dateStar = serieSelected.startToSee(new Date());
				/*
				for (int i = 0; i < 10000; i++) {
					System.out.println("Viewing ...");
				}*/
				/*
				serieSelected.stopToSee(dateStar, new Date());
				System.out.println("");
				System.out.println("Viste: " + serieSelected);
				System.out.println("Por: "+serieSelected.getTimeViewed() + " milisegundos");
				 */
			}
		} while (opcion!=0);
	}

	private static void showSeries() {
		// TODO Auto-generated method stub
		System.out.println("-- Cataloge of Series --");
		byte opcion = (byte)(0);
		do {

			System.out.println("\n --- Select your serie: ---");
			for (int index = 0; index < series.size(); index++) {
				System.out.println((index+1)+series.get(index).getTitle() + " "+series.get(index).getViewed());
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;

			if(opcion>0) {

				Serie serieSelected = series.get(opcion-1);
				serieSelected.setViewed(true);
				//Date dateStar = serieSelected.startToSee(new Date());

				for (int i = 0; i < 10000; i++) {
					System.out.println("Viewing ...");
				}
				/*
				serieSelected.stopToSee(dateStar, new Date());
				System.out.println("");
				System.out.println("Viste: " + serieSelected);
				System.out.println("Por: "+serieSelected.getTimeViewed() + " milisegundos");
				 */
			}
		} while (opcion!=0);
	}

	private static void showMovies() {
		// TODO Auto-generated method stub
		System.out.println("-- Cataloge of movies --");
		byte opcion = (byte)(0);
		do {

			System.out.println("\n --- Select your movie: ---");
			for (int index = 0; index < movies.size(); index++) {
				System.out.println((index+1)+movies.get(index).getTitle() + " "+movies.get(index).getViewed());
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;//showMenu();

			if(opcion>0) {

				Movie movieSelected = movies.get(opcion-1);
				movieSelected.view();
			}
		} while (opcion!=0);
	}

	private static void showBooks() {
		System.out.println("-- Cataloge of Books--");
		byte opcion = (byte)(0);
		do {

			System.out.println("\n --- Select your Book: ---");
			for (int index = 0; index < books.size(); index++) {
				System.out.println((index+1)+books.get(index).getTitle() + " ");
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;//showMenu();

			if(opcion>0) {

				Book movieSelected = books.get(opcion-1);
				movieSelected.view();
			}
		} while (opcion!=0);
	}

	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();


			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).getViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			//Leer Respuesta usuario
			Scanner scan = new Scanner(System.in);
			int response = Byte.valueOf(scan.nextLine());

			if(response == 0) {
				exit = 0;
			}

			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
			}
		}while(exit !=0);
	}

}

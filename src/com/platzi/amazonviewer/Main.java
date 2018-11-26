package com.platzi.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.platzi.amazonviewer.model.Magazine;
import com.platzi.amazonviewer.model.Movie;
import com.platzi.amazonviewer.model.Serie;

public class Main {

	static ArrayList<Movie> movies = Movie.makeMovies();
	static ArrayList<Serie> series = Serie.makeSeries();
	static ArrayList<Magazine> magazines = Magazine.makeMagazines();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();

	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		byte option = (byte)(0);
		Scanner sc;

		do {
			System.out.println("-- Welcome to AmazonViewer! --");
			System.out.println("-- Menú: --");
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
				System.out.println((index+1)+series.get(index).getTitle() + " "+series.get(index).isViewed());
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
				System.out.println((index+1)+movies.get(index).getTitle() + " "+movies.get(index).isViewed());
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;//showMenu();

			if(opcion>0) {

				Movie movieSelected = movies.get(opcion-1);
				movieSelected.setViewed(true);
				Date dateStar = movieSelected.startToSee(new Date());

				for (int i = 0; i < 10000; i++) {
					System.out.println("Viewing ...");
				}

				movieSelected.stopToSee(dateStar, new Date());
				System.out.println("");
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: "+movieSelected.getTimeViewed() + " milisegundos");
			}
		} while (opcion!=0);
	}

	private static void showBooks() {
		System.out.println("-- Cataloge of Books--");
		byte opcion = (byte)(0);
		do {

			System.out.println("\n --- Select your serie: ---");
			for (int index = 0; index < movies.size(); index++) {
				System.out.println((index+1)+movies.get(index).getTitle() + " "+movies.get(index).isViewed());
			}

			System.out.println("0. Back.");
			Scanner scan = new Scanner(System.in);
			opcion = Byte.valueOf(scan.nextLine());
			if(opcion==0)
				return;//showMenu();

			if(opcion>0) {

				Movie movieSelected = movies.get(opcion-1);
				movieSelected.setViewed(true);
				Date dateStar = movieSelected.startToSee(new Date());

				for (int i = 0; i < 10000; i++) {
					System.out.println("Viewing ...");
				}

				movieSelected.stopToSee(dateStar, new Date());
				System.out.println("");
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: "+movieSelected.getTimeViewed() + " milisegundos");
			}
		} while (opcion!=0);
	}



}

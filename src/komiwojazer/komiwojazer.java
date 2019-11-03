package komiwojazer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class komiwojazer {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("C:\\UE\\rok3s1\\gry strategiczne\\berlin.txt"));
		int quantityOfCity = scan.nextInt();

		Integer[][] tableOfCity = load(quantityOfCity);
		Integer[][] tableOfIndex = los(quantityOfCity);
		liczenieOdleglosci(tableOfCity, tableOfIndex, quantityOfCity);

	}

	static Integer[] liczenieOdleglosci(Integer[][] city, Integer[][] index, int quantityOfCity) {

		Integer[] distance = new Integer[quantityOfCity];
		distance[0] = 0;
		int sprI = 0;
		int sprC = 0;
		for (int i = 0; i < quantityOfCity; i++) {
			for (int j = 0; j < quantityOfCity; j++) {
				
				sprI = index[i][j];
				sprC = city[i][index[i][j]];
				if(j<quantityOfCity-1)
				distance[i] = distance[i] + city[index[i][j+1]][index[i][j]];
				else {
					distance[i]+=city[index[i][j]][index[i][0]];
				}
			}
			// distance[i]=distance[i]+city

		}

		return null;
	}

	static Integer[][] load(int liczbaMiast) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("C:\\UE\\rok3s1\\gry strategiczne\\berlin.txt"));
		int licznik = 1;

		Integer[][] tab = new Integer[liczbaMiast][liczbaMiast];
		scan.nextInt();
		for (int i = 0; i < liczbaMiast; i++) {

			for (int j = 0; j < licznik; j++) {
				tab[i][j] = scan.nextInt();
			}
			licznik++;
		}
		for (int i = 0; i < liczbaMiast; i++) {

			for (int j = 0; j < liczbaMiast; j++) {
				tab[i][j] = tab[j][i];
			}

		}
		scan.close();

		return tab;
	}

	static Integer[][] los(int m) {
		Integer[][] tablica2 = new Integer[m][m];
		Integer[] tablica = new Integer[m];
		for (int j = 0; j < m; j++) {

			for (int i = 0; i < m; i++) {
				tablica[i] = i;
			}
			Collections.shuffle(Arrays.asList(tablica));

			for (int i = 0; i < m; i++) {
				tablica2[j][i] = tablica[i];
			}

		}

		return tablica2;
	}

//	static int[][] losowanie(int m) {
//		int[][] tab = new int[m][m];
//		int rand = 0;
//		Random r = new Random();
//
//		for (int n = 0; n < tab.length; n++) {
//
//			for (int i = 0; i < tab.length; i++) {
//				tab[n][i] = -1;
//			}
//			rand = r.nextInt(m);
//			tab[n][0] = rand;
//			for (int i = 1; i < m; i++) {
//				rand = r.nextInt(m);
//
//				for (int j = 0; j < m; j++) {
//
//					if (tab[n][j] == rand) {
//						j = -1;
//						rand = r.nextInt(m);
//					}
//
//				}
//				tab[n][i] = rand;
//
//			}
//
//		}
//		return tab;
//	}

}

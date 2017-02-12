/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szachy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author aleksandra
 */
public class GraczLosowy implements IGracz {

	private Kolor kolor;

	public GraczLosowy(Kolor kolor) {
		this.kolor = kolor;
	}

	public boolean wykonajRuch(Pole[][] szachownica) {

		// HashMap<Bierka, List<int[]> > mozliweRuchy = new HashMap<Bierka,
		// List<int[]>>();

		HashMap<Bierka, int[]> listaBierekZIchWspolrzednymi = new HashMap<Bierka, int[]>();
		int[] poczatkoweWspolrzedne;

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				if (szachownica[i][j].getFigura() != null
						&& szachownica[i][j].getFigura().getKolorFigury() == this.kolor) {

					listaBierekZIchWspolrzednymi.put(szachownica[i][j].getFigura(), new int[] { i, j });

					// znalezc liste wszystkich pionków gracza, wylosować jeden,
					// sprawdzić jakie ma ruchy, wybrać jeden, jak nie to
					// losowac kolejny i tak do usranej śmierci
				}
			}

		while (listaBierekZIchWspolrzednymi.size() != 0) {

			Bierka losowaBierka;

			if (listaBierekZIchWspolrzednymi.size() == 0) {
				System.out.println("Gracz " + this.kolor.name() + " przegral. Brak dostepnych bierek.");
				return false;

			} else {

				losowaBierka = listaBierekZIchWspolrzednymi.keySet().stream().collect(Collectors.toList())
						.get(new Random().nextInt(listaBierekZIchWspolrzednymi.size()));

				poczatkoweWspolrzedne = listaBierekZIchWspolrzednymi.get(losowaBierka);
				listaBierekZIchWspolrzednymi.remove(losowaBierka);

			}

			List<int[]> listaRuchow = losowaBierka.pobierzListeRuchow(szachownica, poczatkoweWspolrzedne);

			// wylosuj ruch, jezeli lista pusta to losuj nastepna bierke
			if (listaRuchow.size() == 0)
				continue;

			int[] wspolrzedneKoncowe = listaRuchow.get(new Random().nextInt(listaRuchow.size()));

			// wykonaj

			System.out.println("Losowa: " + losowaBierka);

			szachownica[poczatkoweWspolrzedne[0]][poczatkoweWspolrzedne[1]].setFigura(null);

			if (szachownica[wspolrzedneKoncowe[0]][wspolrzedneKoncowe[1]].getFigura() == null) { // ruch
																									// bez
																									// bicia
				szachownica[wspolrzedneKoncowe[0]][wspolrzedneKoncowe[1]].setFigura(losowaBierka);

				System.out.println("Ruch bez bicia gracza: " + this.getKolor() + " " + losowaBierka + " z pola: ("
						+ (poczatkoweWspolrzedne[0]+1) + "," + (char) (poczatkoweWspolrzedne[1]+65) + ") na pole: ("
						+ (wspolrzedneKoncowe[0]+1) + "," + (char) (wspolrzedneKoncowe[1]+65) + ")");
				return true;

			} else { // bicie

				System.out.println("Bicie gracza: " + this.getKolor() + " " + losowaBierka + " z pola: ("
						+ (poczatkoweWspolrzedne[0]+1) + "," + (char) (poczatkoweWspolrzedne[1]+65) + ") na pole: ("
						+ (wspolrzedneKoncowe[0]+1) + "," + (char) (wspolrzedneKoncowe[1]+65) + ")" + " zbija: "
						+ szachownica[wspolrzedneKoncowe[0]][wspolrzedneKoncowe[1]].getFigura());

				szachownica[wspolrzedneKoncowe[0]][wspolrzedneKoncowe[1]].setFigura(losowaBierka);
				return true;
			}

			// pobierz liste ruchow dla wylosowanej bierki, wykonaj losowa,
			// zwroc
			// wynik

		}
		
		System.out.println("Gracz " + this.kolor.name() + " przegral. Brak dostepnych ruchow.");

		return false;

	}

	@Override
	public void setKolor(Kolor kolor) {
		this.kolor = kolor;
	}

	@Override
	public Kolor getKolor() {
		return kolor;
	}

}

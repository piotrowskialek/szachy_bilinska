/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szachy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author aleksandra
 */
public class Pionek extends Bierka {

	public Pionek(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "P";

		else
			return "p";
	}

	@Override
	public List<int[]> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {

		int rzedy = wspolrzedne[0], kolumny = wspolrzedne[1];

		List<int[]> listaRuchow = new ArrayList<int[]>();

		// czy mozesz isc do przodu lub bic po skosie
		if (this.getKolorFigury() == Kolor.BIALY) { // idz w dol

			try { // rows then columns...
				/* sprawdz do przodu */
				if (szachownica[rzedy + 1][kolumny].getFigura() == null) {
					listaRuchow.add(new int[] { rzedy + 1, kolumny });
				}
			} catch (IndexOutOfBoundsException e) {
			}

			try {
				/* sprawdz bicie po skosie w prawo */
				if (szachownica[rzedy + 1][kolumny + 1].getFigura() != null
						&& szachownica[rzedy + 1][kolumny + 1].getFigura().getKolorFigury() != Kolor.BIALY) {
					listaRuchow.add(new int[] { rzedy + 1, kolumny + 1 });
				}
			} catch (IndexOutOfBoundsException e) {
			}

			try {
				/* sprawdz po skosie w lewo */
				if (szachownica[rzedy + 1][kolumny - 1].getFigura() != null
						&& szachownica[rzedy + 1][kolumny - 1].getFigura().getKolorFigury() != Kolor.BIALY) {
					listaRuchow.add(new int[] { rzedy + 1, kolumny - 1 });
				}
			} catch (IndexOutOfBoundsException e) {
			}

		} else { // idz w gore

			try { // rows then columns...
				/* sprawdz do przodu */
				if (szachownica[rzedy - 1][kolumny].getFigura() == null) {
					listaRuchow.add(new int[] { rzedy - 1, kolumny });
				}
			} catch (IndexOutOfBoundsException e) {
			}

			try {
				/* sprawdz bicie po skosie w prawo */
				if (szachownica[rzedy - 1][kolumny + 1].getFigura() != null
						&& szachownica[rzedy - 1][kolumny + 1].getFigura().getKolorFigury() != Kolor.CZARNY) {
					listaRuchow.add(new int[] { rzedy - 1, kolumny + 1 });
				}
			} catch (IndexOutOfBoundsException e) {
			}

			try {
				/* sprawdz po skosie w lewo */
				if (szachownica[rzedy - 1][kolumny - 1].getFigura() != null
						&& szachownica[rzedy - 1][kolumny - 1].getFigura().getKolorFigury() != Kolor.CZARNY) {
					listaRuchow.add(new int[] { rzedy - 1, kolumny - 1 });
				}
			} catch (IndexOutOfBoundsException e) {
			}
		}

		return listaRuchow;

	}
}

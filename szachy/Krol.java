/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szachy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksandra
 */
public class Krol extends Bierka {

	public Krol(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "K";

		else
			return "k";
	}

	@Override
	public List<int[]> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {
		List<int[]> listaRuchow = new ArrayList<int[]>();
		int rzedy = wspolrzedne[0], kolumny = wspolrzedne[1];

		try {

			if (szachownica[rzedy + 1][kolumny + 1].getFigura() == null
					|| szachownica[rzedy + 1][kolumny + 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 1, kolumny + 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy + 1][kolumny - 1].getFigura() == null
					|| szachownica[rzedy + 1][kolumny - 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 1, kolumny - 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 1][kolumny + 1].getFigura() == null
					|| szachownica[rzedy - 1][kolumny + 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 1, kolumny + 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 1][kolumny - 1].getFigura() == null
					|| szachownica[rzedy - 1][kolumny - 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 1, kolumny - 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		} // po skosie

		try {

			if (szachownica[rzedy + 1][kolumny].getFigura() == null
					|| szachownica[rzedy + 1][kolumny].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 1, kolumny });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy][kolumny + 1].getFigura() == null
					|| szachownica[rzedy][kolumny + 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy, kolumny + 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {

			if (szachownica[rzedy - 1][kolumny].getFigura() == null
					|| szachownica[rzedy - 1][kolumny].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 1, kolumny });
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {

			if (szachownica[rzedy][kolumny - 1].getFigura() == null
					|| szachownica[rzedy][kolumny - 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy, kolumny - 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		} //po bokach w lewo w prawo w gore i w dol

		return listaRuchow;

	}
}

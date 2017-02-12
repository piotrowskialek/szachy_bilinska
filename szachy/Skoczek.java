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
public class Skoczek extends Bierka {

	public Skoczek(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "S";

		else
			return "s";
	}

	@Override
	public List<int[]> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {
		List<int[]> listaRuchow = new ArrayList<int[]>();
		int rzedy = wspolrzedne[0], kolumny = wspolrzedne[1];

		try {

			if (szachownica[rzedy + 2][kolumny + 1].getFigura() == null
					|| szachownica[rzedy + 2][kolumny + 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 2, kolumny + 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy + 2][kolumny - 1].getFigura() == null
					|| szachownica[rzedy + 2][kolumny - 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 2, kolumny - 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 2][kolumny + 1].getFigura() == null
					|| szachownica[rzedy - 2][kolumny + 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 2, kolumny + 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 2][kolumny - 1].getFigura() == null
					|| szachownica[rzedy - 2][kolumny - 1].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 2, kolumny - 1 });
			}
		} catch (IndexOutOfBoundsException e) {
		}
		// pionowo 2 poziomo 1 ^

		try {

			if (szachownica[rzedy + 1][kolumny + 2].getFigura() == null
					|| szachownica[rzedy + 1][kolumny + 2].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 1, kolumny + 2 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy + 1][kolumny - 2].getFigura() == null
					|| szachownica[rzedy + 1][kolumny - 2].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy + 1, kolumny - 2 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 1][kolumny + 2].getFigura() == null
					|| szachownica[rzedy - 1][kolumny + 2].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 1, kolumny + 2 });
			}
		} catch (IndexOutOfBoundsException e) {
		}

		try {

			if (szachownica[rzedy - 1][kolumny - 2].getFigura() == null
					|| szachownica[rzedy - 1][kolumny - 2].getFigura().getKolorFigury() != this.getKolorFigury()) {

				listaRuchow.add(new int[] { rzedy - 1, kolumny - 2 });
			}
		} catch (IndexOutOfBoundsException e) {
		}
		// pionowo 1, poziomo 2

		return listaRuchow;
	}
}

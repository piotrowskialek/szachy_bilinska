
package szachy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksandra
 */
public class Hetman extends Bierka {

	public Hetman(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "H";

		else
			return "h";
	}

	@Override
	public List<int[]> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) { //najpierw po skosie, potem pionowo poziomo
		List<int[]> listaRuchow = new ArrayList<int[]>();

		int rzedy = wspolrzedne[0], kolumny = wspolrzedne[1];

		try {

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy + i][kolumny + i].getFigura() == null) { // jezeli
																				// puste
																				// to
																				// dodaj
																				// mozliwosc

					listaRuchow.add(new int[] { rzedy + i, kolumny + i });

				} else if (szachownica[rzedy + i][kolumny + i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																														// bic
					listaRuchow.add(new int[] { rzedy + i, kolumny + i });
					break;
					
				} else if (szachownica[rzedy + i][kolumny + i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																														// moze
																														// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try {

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy + i][kolumny - i].getFigura() == null) { // jezeli
																				// puste
																				// to
																				// dodaj
																				// mozliwosc

					listaRuchow.add(new int[] { rzedy + i, kolumny - i });

				} else if (szachownica[rzedy + i][kolumny - i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																														// bic
					listaRuchow.add(new int[] { rzedy + i, kolumny - i });
					break;
					
				} else if (szachownica[rzedy + i][kolumny - i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																														// moze
																														// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try {

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy - i][kolumny + i].getFigura() == null) { // jezeli
																				// puste
																				// to
																				// dodaj
																				// mozliwosc

					listaRuchow.add(new int[] { rzedy - i, kolumny + i });

				} else if (szachownica[rzedy - i][kolumny + i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																														// bic
					listaRuchow.add(new int[] { rzedy - i, kolumny + i });
					break;

				} else if (szachownica[rzedy - i][kolumny + i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																														// moze
																														// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try {

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy - i][kolumny - i].getFigura() == null) { // jezeli
																				// puste
																				// to
																				// dodaj
																				// mozliwosc

					listaRuchow.add(new int[] { rzedy - i, kolumny - i });

				} else if (szachownica[rzedy - i][kolumny - i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																														// bic
					listaRuchow.add(new int[] { rzedy - i, kolumny - i });
					break;

				} else if (szachownica[rzedy - i][kolumny - i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																														// moze
																														// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}
		
		try { // w dol

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy + i][kolumny].getFigura() == null) { // jezeli
																			// puste
																			// to
																			// dodaj
																			// mozliwosc

					listaRuchow.add(new int[] { rzedy + i, kolumny });

				} else if (szachownica[rzedy + i][kolumny].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																													// bic
					listaRuchow.add(new int[] { rzedy + i, kolumny });
					break;

				} else if (szachownica[rzedy + i][kolumny].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																													// moze
																													// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try { // w lewo

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy][kolumny - i].getFigura() == null) { // jezeli
																			// puste
																			// to
																			// dodaj
																			// mozliwosc

					listaRuchow.add(new int[] { rzedy, kolumny - i });

				} else if (szachownica[rzedy][kolumny - i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																													// bic
					listaRuchow.add(new int[] { rzedy, kolumny - i });
					break;

				} else if (szachownica[rzedy][kolumny - i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																													// moze
																													// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try { // w gore

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy - i][kolumny].getFigura() == null) { // jezeli
																			// puste
																			// to
																			// dodaj
																			// mozliwosc

					listaRuchow.add(new int[] { rzedy - i, kolumny });

				} else if (szachownica[rzedy - i][kolumny].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																													// bic
					listaRuchow.add(new int[] { rzedy - i, kolumny });
					break;

				} else if (szachownica[rzedy - i][kolumny].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																													// moze
																													// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}

		try { // w prawo

			for (int i = 1; i < 8; i++) {

				if (szachownica[rzedy][kolumny + i].getFigura() == null) { // jezeli
																			// puste
																			// to
																			// dodaj
																			// mozliwosc

					listaRuchow.add(new int[] { rzedy, kolumny + i });

				} else if (szachownica[rzedy][kolumny + i].getFigura().getKolorFigury() != this.getKolorFigury()) { // mozna
																													// bic
					listaRuchow.add(new int[] { rzedy, kolumny + i });
					break;

				} else if (szachownica[rzedy][kolumny + i].getFigura().getKolorFigury() == this.getKolorFigury()) // nie
																													// moze
																													// przeskoczyc
					break;

			}

		} catch (IndexOutOfBoundsException e) {
		}


		return listaRuchow;
	}
}

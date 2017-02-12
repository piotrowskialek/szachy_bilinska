
package szachy;

import java.util.ArrayList;
import java.util.List;

public class Goniec extends Bierka {

	public Goniec(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "G";

		else
			return "g";
	}

	@Override
	public List<int[]> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {
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

		return listaRuchow;
	}
}


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

		return listaRuchow;
	}
}

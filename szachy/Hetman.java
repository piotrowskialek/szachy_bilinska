
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
	public List<int []> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {
		List<int []> listaRuchow = new ArrayList<int []>();
		return listaRuchow;
	}
}


package szachy;

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
}

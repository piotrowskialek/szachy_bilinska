
package szachy;

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
}

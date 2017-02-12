
package szachy;

import java.util.List;

public abstract class Bierka {
	private Kolor kolorFigury;

	Bierka(Kolor kolor){
		kolorFigury=kolor;
	}
	
	public Kolor getKolorFigury() {
		return kolorFigury;
	}

	public void setKolorFigury(Kolor kolorFigury) {
		this.kolorFigury = kolorFigury;
	}
	
	public abstract List<int []> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne);
	
}

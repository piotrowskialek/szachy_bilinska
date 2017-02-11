
package szachy;

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

}

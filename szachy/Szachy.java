
package szachy;

public class Szachy {

	private Pole[][] szachownica = new Pole[8][8];
	private int licznikTur = 0;
	private Gracz graczBialy = new Gracz(Kolor.BIALY);
	private Gracz graczCzarny = new Gracz(Kolor.CZARNY);
	private boolean statusGraczy = true;

	private void ustawBierki() {

		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j) {
				szachownica[i][j] = new Pole();
			}

		Kolor bialy = Kolor.BIALY;
		Kolor czarny = Kolor.CZARNY;

		szachownica[0][0].setFigura(new Wieza(bialy));
		szachownica[0][1].setFigura(new Skoczek(bialy));
		szachownica[0][2].setFigura(new Goniec(bialy));
		szachownica[0][3].setFigura(new Krol(bialy));
		szachownica[0][4].setFigura(new Hetman(bialy));
		szachownica[0][5].setFigura(new Goniec(bialy));
		szachownica[0][6].setFigura(new Skoczek(bialy));
		szachownica[0][7].setFigura(new Wieza(bialy));

		for (int i = 0; i < 8; ++i) {

			szachownica[1][i].setFigura(new Pionek(bialy));
		}

		for (int i = 2; i < 6; ++i)
			for (int j = 0; j < 8; ++j) {
				szachownica[i][j].setFigura(null);

			}

		szachownica[7][0].setFigura(new Wieza(czarny));
		szachownica[7][1].setFigura(new Skoczek(czarny));
		szachownica[7][2].setFigura(new Goniec(czarny));
		szachownica[7][3].setFigura(new Hetman(czarny));
		szachownica[7][4].setFigura(new Krol(czarny));
		szachownica[7][5].setFigura(new Goniec(czarny));
		szachownica[7][6].setFigura(new Skoczek(czarny));
		szachownica[7][7].setFigura(new Wieza(czarny));

		for (int i = 0; i < 8; ++i) {

			szachownica[6][i].setFigura(new Pionek(czarny));
		}

	}

	public void drukujSzachownice() {

		for (char i = 'A'; i != 'I'; i++) {
			System.out.print(" " + i + " ");
		}

		for (int i = 0; i < 8; ++i) {
			System.out.println(" ");
			System.out.print(i + 1);

			for (int j = 0; j < 8; j++)
				System.out.print(szachownica[i][j]);

		}
		System.out.println("");
		System.out.println("Tura nr.: " + this.licznikTur + "\n");

	}

	public boolean krecaSie() {

		int licznikKrolow = 0;
		Kolor kolor = null;

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (szachownica[i][j].getFigura() instanceof Krol) { // if 2
																		// krolowie
					if (licznikKrolow == 1)
						return true;
					else {
						licznikKrolow++;
						kolor = szachownica[i][j].getFigura().getKolorFigury();
					}
				}

		if (licznikKrolow == 1)
			System.out.println("Koniec gry. Wygral gracz: " + kolor.name());

		return false;
	}

	public static void main(String[] args) {

		Szachy szachy = new Szachy();
		szachy.ustawBierki();

		while (szachy.krecaSie() && szachy.licznikTur != 50 && szachy.statusGraczy) {
			szachy.drukujSzachownice();
			
			szachy.statusGraczy &= (szachy.graczBialy.wykonajRuch(szachy.szachownica)
					& szachy.graczCzarny.wykonajRuch(szachy.szachownica));

			szachy.licznikTur++;
		}

		if (szachy.licznikTur == 50)
			System.out.println("Koniec gry. Remis.");

	}

}

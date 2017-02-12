
package szachy;

import java.util.Random;

public class Szachy {

	private Pole[][] szachownica = new Pole[8][8];
	private int licznikTur = 0;
	private GraczLosowy graczBialy = new GraczLosowy(Kolor.BIALY);
	private GraczLosowy graczCzarny = new GraczLosowy(Kolor.CZARNY);
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

		System.out.print(" ");
		
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

		int licznikKroli = 0;
		Kolor kolor = null;

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (szachownica[i][j].getFigura() instanceof Krol) { // if 2
																		// krolowie
					if (licznikKroli == 1)
						return true;
					else {
						licznikKroli++;
						kolor = szachownica[i][j].getFigura().getKolorFigury();
					}
				}

		if (licznikKroli < 2) // sprawdzic sytuacje zbija krola i drugi znowu
								// zbija
			System.out.println("Koniec gry. Wygral gracz: " + kolor.name() + " zbijajac krola.");

		return false;
	}

	public void rozpocznijGre() {

		this.ustawBierki();

		do {
			this.drukujSzachownice();

			this.statusGraczy = this.graczBialy.wykonajRuch(this.szachownica);

			if (!this.krecaSie()) { // moze byc sytuacja ze bialy zbil krola
										// gdyby nie ten if
										// czarny mimo to gralby dalej przez 1
										// ture

				break;
			}

			this.statusGraczy &= this.graczCzarny.wykonajRuch(this.szachownica);

			this.licznikTur++;
		} while (this.krecaSie() && this.licznikTur != 50 && this.statusGraczy);

		if (this.licznikTur == 50)
			System.out.println("Koniec gry. Remis.");

		this.drukujSzachownice();

	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szachy;

/**
 *
 * @author aleksandra
 */
public class Skoczek extends Bierka {

	public Skoczek(Kolor kolor) {
		super(kolor);
	}

	@Override
	public String toString() {
		if (getKolorFigury() == Kolor.BIALY)

			return "S";

		else
			return "s";
	}
}

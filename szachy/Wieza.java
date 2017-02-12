/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szachy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksandra
 */
public class Wieza extends Bierka {
    
    public Wieza(Kolor kolor){
    	super(kolor);
    }
    
    @Override
    public String toString(){
        if(getKolorFigury() ==Kolor.BIALY)

            return "W";

        else return "w";
    }

	@Override
	public List<int []> pobierzListeRuchow(Pole[][] szachownica, int[] wspolrzedne) {
		List<int []> listaRuchow = new ArrayList<int []>();
		return listaRuchow;
	}
}

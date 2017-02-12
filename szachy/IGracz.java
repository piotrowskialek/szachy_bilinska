package szachy;

public interface IGracz {
	
	public boolean wykonajRuch(Pole[][] szachownica);
	public void setKolor(Kolor kolor);
	public Kolor getKolor();
	
}

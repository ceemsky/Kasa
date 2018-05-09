package kasa;

public class Pozycja {
	String nazwaTowaru;
	double cena;
	int liczbaSztuk;
	double cenaCalkowita;
	Pozycja(String nazwaTowaru,int liczbaSztuk,double cena){
		this.nazwaTowaru=nazwaTowaru;
		this.liczbaSztuk=liczbaSztuk;
		this.cena=cena;
		this.cenaCalkowita=this.liczbaSztuk*this.cena;
	}
	public double obliczWartosc() {
		return this.liczbaSztuk*this.cena;
	}
	@Override
	public String toString() {
		return nazwaTowaru+" "+cena+" "+liczbaSztuk+" "+cenaCalkowita;
	}
}

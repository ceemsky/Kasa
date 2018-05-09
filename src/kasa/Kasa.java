package kasa;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class Kasa {
	private int nip;
	private String nazwa;
	private String adres;
	private int numerUrzadzenia;
	private Paragon[] listaParagonow;
	int ileParagonow;
	Kasa(int nip,String nazwa,String adres,int numerUrzadzenia){
		this.nip=nip;
		this.nazwa=nazwa;
		this.adres=adres;
		this.numerUrzadzenia=numerUrzadzenia;
		listaParagonow=new Paragon[20];
		ileParagonow=0;
	}
	int getNip() {
		return nip;
	}
	String getNazwa() {
		return nazwa;
	}
	String getAdres() {
		return adres;
	}
	int getNumerUrzadzenia() {
		return numerUrzadzenia;
	}
	Paragon utworzParagon(LocalDateTime dataCzas) {
		listaParagonow[ileParagonow]=new Paragon(20,dataCzas,this) ;
		ileParagonow++;
		return listaParagonow[ileParagonow-1];
	}
	void wydrukujParagony(LocalDate data) {
		for(int i=0;i<ileParagonow;i++)
			if(listaParagonow[i].dataICzas.toLocalDate().equals(data))
				System.out.println(listaParagonow[i]);
	}
	@Override
	public String toString() {
		return nip+nazwa+adres+numerUrzadzenia;
	}
	public static void main(String args[]) {
		Kasa kasa=new Kasa(465498,"biedra","wroc³awska",1);
		Paragon p1=kasa.utworzParagon(LocalDateTime.of(LocalDate.of(2018, 4, 24),LocalTime.of(12,43)));
		Paragon p2=kasa.utworzParagon(LocalDateTime.of(LocalDate.of(2018, 4, 24),LocalTime.of(15,21)));
		Paragon p3=kasa.utworzParagon(LocalDateTime.of(LocalDate.of(2018, 4, 26),LocalTime.of(12,43)));
		Pozycja poz1=new Pozycja("ciastka",4,3.2);
		Pozycja poz2=new Pozycja("chleb",2,2.3);
		p1.dodajPozycje(poz1);
		p1.dodajPozycje(poz2);
		p2.dodajPozycje(poz2);
		p3.dodajPozycje(poz1);
		kasa.wydrukujParagony(LocalDate.of(2018, 4, 24));
		System.out.println(kasa);
	}
}

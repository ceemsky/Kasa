package kasa;
import java.time.LocalDateTime;
public class Paragon {
	Pozycja[] listaPozycji;
	int ileDodanych;
	int maxRozmiar;
	LocalDateTime dataICzas;
	Kasa kasa;
	Paragon(){
		maxRozmiar=10;
		listaPozycji=new Pozycja[maxRozmiar];
		ileDodanych=0;
	}
	Paragon(int maxRozmiar,LocalDateTime dataICzas,Kasa kasa){
		this.maxRozmiar=maxRozmiar;
		listaPozycji=new Pozycja[maxRozmiar];
		ileDodanych=0;
		this.dataICzas=dataICzas;
		this.kasa=kasa;
	}
	void dodajPozycje(Pozycja pozycja) {
		if(ileDodanych<maxRozmiar-1) {
		listaPozycji[ileDodanych]=pozycja;
		ileDodanych++;
		}
		else
			System.out.println("brak miejsca na paragonie");
	}
	double obliczWartosc() {
		double calkowitaWartosc=0.;
		for(int i=0;i<ileDodanych;i++) {
			calkowitaWartosc+=listaPozycji[i].obliczWartosc();
		}
		return calkowitaWartosc;
	}
	@Override
	public String toString() {
		String toRet= "";
		toRet+=kasa.getNazwa()+kasa.getAdres()+"\n";
		for(int i=0;i<ileDodanych;i++) {
			toRet+=listaPozycji[i]+"\n";
		}
		toRet+="suma: "+obliczWartosc()+"\n";
		toRet+=dataICzas+"\n"+kasa.getNumerUrzadzenia();
		return toRet;
	}
}

package batch_insert11;

import java.util.ArrayList;

public class AppTest {

	public static void main(String[] args) {

		ArrayList<Personel> personelListe = new ArrayList<>();
		
		personelListe.add(new Personel(301,"Nazlý","Küçük"));
		personelListe.add(new Personel(302, "Berçem", "Berrak"));
		personelListe.add(new Personel(303,"Kýzýl","Karalý"));
		personelListe.add(new Personel(304, "Alev", "Ateþ"));
		
		DBProcesses islem = new DBProcesses();
		
		islem.personellerEkle(personelListe);

	}

}

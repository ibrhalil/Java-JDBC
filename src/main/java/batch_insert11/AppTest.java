package batch_insert11;

import java.util.ArrayList;

public class AppTest {

	public static void main(String[] args) {

		ArrayList<Personel> personelListe = new ArrayList<>();
		
		personelListe.add(new Personel(301,"Nazl�","K���k"));
		personelListe.add(new Personel(302, "Ber�em", "Berrak"));
		personelListe.add(new Personel(303,"K�z�l","Karal�"));
		personelListe.add(new Personel(304, "Alev", "Ate�"));
		
		DBProcesses islem = new DBProcesses();
		
		islem.personellerEkle(personelListe);

	}

}

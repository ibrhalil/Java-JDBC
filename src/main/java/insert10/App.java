package insert10;

public class App {

	public static void main(String[] args) {

		DBProcesses islem = new DBProcesses();
		
		islem.personelEkle(new Personel(201, "Kara", "Cuma"));
		islem.personelEkle(new Personel(202, "Ali", "K�r"));
		islem.personelEkle(new Personel(203, "Murat", "��l"));
		islem.personelEkle(new Personel(204, "Fidan", "Yeti�tir"));

	}

}

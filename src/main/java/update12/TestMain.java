package update12;

public class TestMain {

	public static void main(String[] args) {
		DBProcesses islem = new DBProcesses();
		Personel guncelPersonel = islem.personelGuncelle(new Personel(202, "Ali", "K�rmaz"));
		System.out.println(guncelPersonel);

	}

}

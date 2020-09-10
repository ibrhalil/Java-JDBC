package search14;

public class Test {

	public static void main(String[] args) {

		DBProcesses islem = new DBProcesses();
		
		Personel personel = islem.personelBul(1001);
		
		System.out.println(personel);

	}

}

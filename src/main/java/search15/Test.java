package search15;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		DBProcesses islem = new DBProcesses();
		
		List<Personel> personels = islem.personelListesi();
		
		personels.forEach(System.out::println);

	}

}

package delete13;

public class Personel 
{
	/*
	 * HATIRLATMA !!!
	 * bu model mysql veritabanýnda önceden hazýrlanmýþ olan tabloya göre düzenlenmekte.
	 */
	
	private int personelId;
	private String ad;
	private String soyad;
	
	public Personel() {
		// TODO Auto-generated constructor stub
	}
	
	public Personel(int personelId,String ad, String soyad)
	{
		this.personelId = personelId;
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", ad=" + ad + ", soyad=" + soyad + "]";
	}

}

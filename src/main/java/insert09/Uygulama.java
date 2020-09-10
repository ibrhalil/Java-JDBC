package insert09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Uygulama 
{
	public static void main(String[] args) 
	{
		Personel p1 = new Personel(1001, "Adnan", "Kuþ");
		Personel p2 = new Personel(1002, "Kazým", "Kale");
		Personel p3 = new Personel(1003, "Murat", "Muþ");
		
		ekleme(p1);
		ekleme(p2);
		ekleme(p3);
		
	}
	
	private static void ekleme(Personel personel) 
	{
		String sorgu = "insert into personel(personelId, ad, soyad) values(?,?,?)";
		
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		
		try 
		{
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personel.getPersonelId());
			preparedStatement.setString(2, personel.getAd());
			preparedStatement.setString(3, personel.getSoyad());
			
			preparedStatement.executeUpdate();
			LogManager.getLogger().info("Ekleme Baþarýlý");
		} 
		catch (SQLException e) 
		{
			LogManager.getLogger().warn("Ekleme sýrasýnda hata meydana geldi.\n"+e);
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}

	}
}

//Baðlantý Sýnýfý 
class DBConnection
{
	private static Connection connection = null;
	private static Logger logger = (Logger) LogManager.getLogger();
	
	public static Connection getConnection() 
	{
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
		String kullanici = "root";
		String sifre = "toor";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e1) 
		{
			logger.warn("Gerekli Sýnýflar bulunamadý !!");
		}
		
		
		try 
		{
			connection = DriverManager.getConnection(url,kullanici,sifre);
		} 
		catch (SQLException e) 
		{
			logger.warn("Baðlantý sýrasýnda hata meydana geldi.\n"+e);
		}
		logger.info("Baðlantý Baþarýlý.");
		return connection;
	}
	
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement) 
	{
		try 
		{
			preparedStatement.close();
			connection.close();
			connection=null;
			logger.info("Baðlantý sonlandýrýldý.");
		} 
		catch (SQLException e) 
		{
			logger.warn("Baðlantý kapatýlýrken bir sorun meydana geldi.\n"+e);
		}
		
	}
}

//personel model
class Personel
{
	private int personelId;
	private String ad;
	private String soyad;
	
	public Personel() {
		
	}
	
	public Personel(int personelId, String ad, String soyad) {
		this.personelId = personelId;
		this.ad = ad;
		this.soyad = soyad;
	}

	
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	public int getPersonelId() {
		return personelId;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getAd() {
		return ad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getSoyad() {
		return soyad;
	}

	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", ad=" + ad + ", soyad=" + soyad + "]";
	}
}
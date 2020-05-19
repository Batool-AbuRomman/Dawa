package pharma;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.Date;

public class Patient {
	private int id ,PhoneNumber,Nationality_Number,Age;
	private String firstName ,last_Name, Country ,Password ,Email ,city ;
	private String birthdate;
	private InputStream image; 
	

	public int getPhoneNumber() {
		return PhoneNumber;
	}
	
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream inputStream)  {
		System.out.print(inputStream);
		this.image=inputStream;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public int Age() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate=formatter.parse(birthdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(myDate);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate l1 = LocalDate.of(year, month, date);
		  LocalDate now1 = LocalDate.now();
		  Period diff1 = Period.between(l1, now1);
		  return diff1.getYears();

	}
	public void setBirthdate(String bdate) {
		/*DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = null;
		try {
			myDate = formatter.parse(bdate);*
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		this.birthdate = bdate;
	}
	public int getNationality_Number() {
		return Nationality_Number;
	}
	public void setNationality_Number(int nationality_Number) {
		Nationality_Number = nationality_Number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	
	

}

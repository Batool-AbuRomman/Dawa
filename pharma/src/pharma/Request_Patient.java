package pharma;

import java.sql.Date;

public class Request_Patient {
	private String Medicine ,pharmacy;
	private  int Dosage ,per_day;
	public int getPer_day() {
		return per_day;
	}
	public void setPer_day(int per_day) {
		this.per_day = per_day;
	}
	private Date date;
	public String getMedicine() {
		return Medicine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setMedicine(String medicine) {
		Medicine = medicine;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public int getDosage() {
		return Dosage;
	}
	public void setDosage(int dosage) {
		Dosage = dosage;
	}
	

}

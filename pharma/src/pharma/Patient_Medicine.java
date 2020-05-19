package pharma;

import java.sql.Date;

public class Patient_Medicine {
	
	private int ID_medicne ,ID_pharma,ID_patient,Dosage ,Dosage_per_day;
	private Date Last_date,Exchange_Date;
	public Date getExchange_Date() {
		return Exchange_Date;
	}
	public void setExchange_Date(Date exchange_Date) {
		Exchange_Date = exchange_Date;
	}
	private String Medicine_name,pharmacy,patient;
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public int getID_patient() {
		return ID_patient;
	}
	public void setID_patient(int iD_patient) {
		ID_patient = iD_patient;
	}
	public int getDosage() {
		return Dosage;
	}
	public void setDosage(int dosage) {
		Dosage = dosage;
	}
	public int getDosage_per_day() {
		return Dosage_per_day;
	}
	public void setDosage_per_day(int dosage_per_day) {
		Dosage_per_day = dosage_per_day;
	}
	public Date getLast_Date() {
		return Last_date;
	}
	public void setLast_Date(Date date) {
		this.Last_date = date;
	}
	public String getMedicine_name() {
		return Medicine_name;
	}
	
	
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public void setMedicine_name(String medicine_name) {
		Medicine_name = medicine_name;
	}
	
	
	
	
	

}

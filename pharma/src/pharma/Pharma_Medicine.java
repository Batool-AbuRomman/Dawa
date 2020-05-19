package pharma;

public class Pharma_Medicine extends Patient_Medicine {
	
	private int Mount;
	private String Expire_Date;
	private String Company,patientname;
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String firstname, String last) {
		String temp=firstname+last;
		this.patientname = temp;
	}
	private boolean accept;
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public int getMount() {
		return Mount;
	}
	public void setMount(int mount) {
		Mount = mount;
	}
	public String getExpire_Date() {
		return Expire_Date;
	}
	public void setExpire_Date(String date) {
		Expire_Date = date;
	}

}

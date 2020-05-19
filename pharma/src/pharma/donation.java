package pharma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class donation {
	private int id ,phone,amount;
	private String firstname ,lastname ,email,country ,city;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int save () throws SQLException {
		Connection con =DBConnection.getConnection();
		String qurey="INSERT INTO `donation`(`FirstName`, `LastName`, `Amount`, `Email`, `Phone`, `Country`, `City`)"
				+ " VALUES (?,?,?,?,?,?,?)";
		 PreparedStatement preparedStmt = null;
		 int state=0;
		 try {
			preparedStmt=con.prepareStatement(qurey);
			preparedStmt.setString(1,this.firstname);
			 preparedStmt.setString(2,this.lastname);
			 preparedStmt.setInt(3,this.amount);
			 preparedStmt.setString(4,this.email);
			 preparedStmt.setInt(5,this.phone);
			 preparedStmt.setString(6,this.country);
			 preparedStmt.setString(7,this.city);
			 state=preparedStmt.executeUpdate();
			 qurey="UPDATE pharmacies SET donation_amount=(select sum(amount) from donation) ";
			 preparedStmt=con.prepareStatement(qurey);
			 int y=preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			con.close();
			
		}
		 return state;
	}

}

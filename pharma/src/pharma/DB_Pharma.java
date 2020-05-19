package pharma;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Pharma extends DBConnection{
	public static int Save(Pharma_info  pharma) throws SQLException   {
		int st=0;
		Connection con=DBConnection.getConnection(); 
		String query = "INSERT INTO `pharmacies`(`Name`, `Number`, `UserName`, `Email`, `Password`, `Country`, `City`, `Logo`,Established_date)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
	    System.out.println("Scess1");
		 PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1,pharma.getName());
		    preparedStmt.setInt (2, pharma.getNumber());
		    preparedStmt.setString (3, pharma.getUsername());
		    preparedStmt.setString (4, pharma.getEmail());
		    preparedStmt.setString (5, pharma.getPassword());
		    preparedStmt.setString (6, pharma.getCountry());
		    preparedStmt.setString (7, pharma.getCity());
		    System.out.println("Scess2");
		    if (pharma.getImage()!=null)
			{
		    	System.out.println("Scess2 ");
		    	preparedStmt.setBlob(8,pharma.getImage() );
			}
		    preparedStmt.setDate (9,Date.valueOf(pharma.getEdate()));
		    st= preparedStmt.executeUpdate();
		    System.out.println("Scess3 ");
		      
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if (preparedStmt!=null)
			preparedStmt.close();
		}
		con.close();
		return st;
	}
	/******************************************************************************/

	public static List<Pharma_info> pharmaies(){
		List<Pharma_info>pharmaies =new ArrayList<Pharma_info>();
		Pharma_info pharma=new Pharma_info();
		Connection con =null;
		con=DBConnection.getConnection();
		String query="SELECT * FROM `pharmacies` ";
		PreparedStatement preparedStmt;
		
			try {
				preparedStmt = con.prepareStatement(query);
				ResultSet rs=preparedStmt.executeQuery();
				while (rs.next()) {
					pharma=new Pharma_info();
					pharma.setId(rs.getInt(1));
					pharma.setName(rs.getString(2));
					pharma.setNumber(rs.getInt(3));
					pharma.setCountry(rs.getString(6));
					pharma.setCity(rs.getString(7));
					pharmaies.add(pharma);
			} 
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return 	pharmaies;
	}
	/********************************************************************************/
	public static Pharma_info RetrievePharma(long arr) {
		Pharma_info pharma=new Pharma_info();
		Connection con=DBConnection.getConnection();
		String query = "SELECT * FROM `pharmacies` WHERE id=?";
		 PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setLong (1,arr);
			ResultSet rs=preparedStmt.executeQuery();
		    if (rs.next()) {
		    	//pharma.setId(rs.getInt(1));
				pharma.setName(rs.getString(2));
				pharma.setNumber(rs.getInt(3));
				pharma.setCountry(rs.getString(6));
				pharma.setCity(rs.getString(7));
		    	
		    }
		      con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pharma;
	}	
	/*************************************************************************************************/
	public static List<Pharma_Medicine> RetrieveALLMedicine(int id) {
		List<Pharma_Medicine> list=new ArrayList<Pharma_Medicine>();
		Pharma_Medicine medicine=new Pharma_Medicine();
		Connection con=DBConnection.getConnection();
		 PreparedStatement preparedStmt;
		try {
		  String  query ="SELECT  medicines.Name , medicines.Company ,Number_of_Medicine ,Expire_date"
		    		+" FROM pharmacy_medicines "
		    		+"INNER JOIN medicines ON pharmacy_medicines.IDMedicine=medicines.Id "
		    		+ "where IDPharma=? ";
		    		
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1,id);
			ResultSet rs2=preparedStmt.executeQuery();
			while (rs2.next()) {
				
				medicine=new Pharma_Medicine();
				medicine.setMedicine_name(rs2.getString(1));
				medicine.setCompany(rs2.getString(2));
				medicine.setMount(rs2.getInt(3));
				medicine.setExpire_Date(String.valueOf(rs2.getDate(4)));
				list.add(medicine);
			}
		      con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}	
	/*********************************************************************************************************************/
	public static List<Pharma_Medicine> RetrieveALLRequest_Patient(int id) {
		List<Pharma_Medicine> list=new ArrayList<Pharma_Medicine>();
		Pharma_Medicine medicine=new Pharma_Medicine();
		Connection con=DBConnection.getConnection();
		 PreparedStatement preparedStmt;
		try {
		  String  query ="SELECT patient.FirstName ,patient.lastName , medicines.Name ,Dosage  , Exchange_Date ,Accept_Request"
		    		+" FROM patient_medication "
		    		+ "INNER JOIN patient ON patient_medication.IdPatient=patient.Id "
		    		+"INNER JOIN medicines ON patient_medication.IDMedicine=medicines.Id "
		    		+ "where IdPharma=?  ";
		    		
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1,id);
			ResultSet rs2=preparedStmt.executeQuery();
			while (rs2.next()) {
				medicine=new Pharma_Medicine();
				medicine.setPatientname(rs2.getString(1),rs2.getString(2) );
				//System.out.println(rs2.getString(1) );
				medicine.setMedicine_name(rs2.getString(3));
				medicine.setDosage(rs2.getInt(4));
				medicine.setExchange_Date(rs2.getDate(5));
				medicine.setAccept(rs2.getBoolean(6));
				list.add(medicine);
			}
		      con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}	
	
	/*************************************************************************************************/
	public static int Addmed( Pharma_Medicine pm, int id) throws SQLException   {
		int st=0;
		Connection con=DBConnection.getConnection(); 
		String query = "INSERT INTO pharmacy_medicines(IDMedicine, Number_of_Medicine, Expire_date,IDPharma) "
				+ "VALUES (?,?,?,?)";
			
		Medicine med=new Medicine();
		med.setName(pm.getMedicine_name());
		//System.out.println(med.getId());
		 PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt (1,med.getId());
		    preparedStmt.setInt (2, pm.getMount());
		    preparedStmt.setDate (3, Date.valueOf(pm.getExpire_Date()));
		    preparedStmt.setInt (4,id);
		    st= preparedStmt.executeUpdate();
		    
		      
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if (preparedStmt!=null)
			preparedStmt.close();
		}
		con.close();
		return st;
	}
}

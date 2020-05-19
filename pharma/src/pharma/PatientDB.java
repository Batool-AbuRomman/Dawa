package pharma;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;


public class PatientDB {

		
		
		//
		public static int Save(Patient patient) throws SQLException   {
			int st=0;
			Connection con=DBConnection.getConnection(); 
			String query = "INSERT INTO `patient`(FirstName , LastName , Email ,Birthdate , Phone_Number ,Nationality_Number , Country, City, PassWord ,Image ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			
			 PreparedStatement preparedStmt = null;
			try {
				
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setString (1,patient.getFirstName());
			    preparedStmt.setString (2, patient.getLast_Name());
			    preparedStmt.setString (3, patient.getEmail());
			    //System.out.println("Scess");
			    preparedStmt.setDate (4,Date.valueOf(patient.getBirthdate()));
			    preparedStmt.setInt (5, patient.getPhoneNumber());
			    preparedStmt.setInt (6, patient.getNationality_Number());
			    preparedStmt.setString (7, patient.getCountry());
			    preparedStmt.setString (8, patient.getCity());
			    preparedStmt.setString (9, patient.getPassword());
			    if (patient.getImage()!=null)
				{
			    	preparedStmt.setBlob(10,patient.getImage() );
				}
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
		public static boolean validate(String email,String pass){  
			boolean status=false;  
			try{  
			  
			 Connection con=DBConnection.getConnection();    
			PreparedStatement ps=con.prepareStatement( "select * from patient where email=? and passWord=?");  
			ps.setString(1,email);  
			ps.setString(2,pass);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			          
			}catch(Exception e){System.out.println(e);}  
			return status;  
			}  

/**********************************************************************************/
		public static Patient RetrievePatient(String email) {
			Patient patient=new Patient();
			Connection con=DBConnection.getConnection();
			String query = "SELECT * FROM `patient` WHERE Email=?";
			 PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setString (1,email);
				ResultSet rs=preparedStmt.executeQuery();
			    if (rs.next()) {
			    	//patient.s(rs.getInt(1));
			    	patient.setFirstName(rs.getString(2));
			    	patient.setLast_Name(rs.getString(3));
			    	patient.setEmail(rs.getString(4));
			    	patient.setBirthdate(String.valueOf(rs.getDate(5)));
			    	patient.setPhoneNumber(rs.getInt(6));
			    	patient.setNationality_Number(rs.getInt(7));
			    	patient.setCountry(rs.getString(8));
			    	patient.setCity(rs.getString(9));
			    	patient.setPassword(rs.getString(10));
			    	
			    }
			      con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return patient;
		}	
		
		public static long getID(String email) {
			long search=0;
			Connection con=DBConnection.getConnection();
			String query = "SELECT Id FROM `patient` WHERE Email=?";
			 PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setString (1,email);
				ResultSet rs=preparedStmt.executeQuery();
			    if (rs.next()) {
			    	search=rs.getLong(1);
			    }
			    else 
			    	{
			    	con.close();
			    	return -1;
			    	}
			}
catch (SQLException e) {
				
				e.printStackTrace();
			}
			return search;
		}
	/**************************************************************************************************/	
		
		public static List<Patient_Medicine> RetrieveMedicine(String email) {
			List<Patient_Medicine> list=new ArrayList<Patient_Medicine>();
			Patient_Medicine medicine=new Patient_Medicine();
			long search=getID(email);
			Connection con=DBConnection.getConnection();
			 PreparedStatement preparedStmt;
			try {
			  String  query ="SELECT pharmacies.Name , medicines.Name , Dosage , Dosage_Per_Day , max(Date)"
			    		+" FROM patient_medication "
			    		+ "INNER JOIN pharmacies ON patient_medication.IDPharma=pharmacies.Id "
			    		+"INNER JOIN medicines ON patient_medication.IDMedicine=medicines.Id "
			    		+ "where IdPatient=?  "
			    		+ "GROUP BY  patient_medication.IDMedicine ";
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setLong (1,search);
				ResultSet rs2=preparedStmt.executeQuery();
				while (rs2.next()) {
					 medicine=new Patient_Medicine();
					medicine.setPharmacy(rs2.getString(1));
					medicine.setMedicine_name(rs2.getString(2));
					medicine.setDosage(rs2.getInt(3));
					medicine.setDosage_per_day(rs2.getInt(4));
					medicine.setLast_Date(rs2.getDate(5));
					list.add(medicine);
				}
			      con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
		}	
		/*****************************************************************************************/
		public static List<Patient_Medicine> RetrieveALLRequest_Patient(String email) {
			List<Patient_Medicine> list=new ArrayList<Patient_Medicine>();
			Patient_Medicine medicine=new Patient_Medicine();
			long search=getID(email);
			Connection con=DBConnection.getConnection();
			 PreparedStatement preparedStmt;
			try {
			  String  query ="SELECT pharmacies.Name , medicines.Name , Dosage , Dosage_Per_Day , Date"
			    		+" FROM patient_medication "
			    		+ "INNER JOIN pharmacies ON patient_medication.IDPharma=pharmacies.Id "
			    		+"INNER JOIN medicines ON patient_medication.IDMedicine=medicines.Id "
			    		+ "where IdPatient=?  ";
			    		
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setLong (1,search);
				ResultSet rs2=preparedStmt.executeQuery();
				while (rs2.next()) {
					 medicine=new Patient_Medicine();
					medicine.setPharmacy(rs2.getString(1));
					medicine.setMedicine_name(rs2.getString(2));
					medicine.setDosage(rs2.getInt(3));
					medicine.setDosage_per_day(rs2.getInt(4));
					medicine.setLast_Date(rs2.getDate(5));
					list.add(medicine);
				}
			      con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
		}	
		/*****************************************************************************************/
		public static int SaveRequest(String email,Request_Patient Rp) {
			
			int st=0,a=0,b=0;
			 PreparedStatement preparedStmt;
			Date date = null;
			ResultSet rs=null;
			
			try {
				Connection con=DBConnection.getConnection();
				
				Timestamp timestamp = new Timestamp(new java.util.Date().getTime());

				/* String query = "INSERT INTO `patient_medication`( `Dosage`,  `Accept_Request`) "
						+ "VALUES (?,?) where medicines.id=(select id from  medicines where name=?) And  patient.id=(select id form patient where email=?) And where phamacies.id=(select id form pharmacies where name=?)";
				*/
				System.out.println(email);
				String query="INSERT INTO `patient_medication`(`IDMedicine`, `IdPatient`, `Dosage`, `Date`, `IDPharma`, `Accept_Request`) "
						+ "VALUES ((select id from medicines where name=?),(select id from patient where Email=?),?,?,(select id from pharmacies where name=?),?)";
				
				 preparedStmt = con.prepareStatement(query);
				 preparedStmt.setString (1,Rp.getMedicine());
				 preparedStmt.setString (2, email);
				 preparedStmt.setInt (3, Rp.getDosage());
			     preparedStmt.setTimestamp(4, timestamp);
			     preparedStmt.setString (5, Rp.getPharmacy());
			     preparedStmt.setBoolean(6, false);  
			    st= preparedStmt.executeUpdate();
			      con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return st;
		}
		
}

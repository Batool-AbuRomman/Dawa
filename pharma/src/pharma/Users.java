package pharma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
	public static long[] Split(String email) {
		Connection con=null;
		long []arr=new long[2];
		 con=DBConnection.getConnection();
		String query = "SELECT Id FROM `patient` WHERE Email=?";
		 PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1,email);
			ResultSet rs=preparedStmt.executeQuery();
		    if (rs.next()) {
		    	arr[0]=1;
		    	arr[1]=rs.getLong(1);
		    	rs=null;
		    }
		    else 
		    	{
		    	 query = "SELECT Id FROM `pharmacies` WHERE `UserName`=?";
		    	 preparedStmt = con.prepareStatement(query);
		    	 preparedStmt.setString (1,email);
		    	 rs=preparedStmt.executeQuery();
		    	 if (rs.next()) {
				    	arr[0]=2;
				    	arr[1]=rs.getInt(1);
				    	rs=null;
				    }
		    	 else {
		    		 arr[0]=arr[1]=-1;
		    	 }
		    	}
		   
		    con.close();
		}
       catch (SQLException e) {
    	  
			e.printStackTrace();
		}
		
		
		return arr;
	}
	/*****************************************************************************************/
	public static boolean validate(long[] arr,String pass){  
		boolean status=false;  
		try{  
		  
		 Connection con=DBConnection.getConnection(); 
		 String query;
		 if (arr[0]==1)
		 query="select * from patient where id=? and passWord=?";
		 else
		query="SELECT * FROM `pharmacies` WHERE id=? and Password=?";
		PreparedStatement ps=con.prepareStatement( query);  
		ps.setLong(1,arr[1]);  
		ps.setString(2,pass);  
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  

}

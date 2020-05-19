package pharma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicine {
 private String name;
 private int id;
public void  setName(String name) {
	Connection con=DBConnection.getConnection();
	PreparedStatement preparedStmt = null;
	String query="select id from medicines where name=?";
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1,name);
		ResultSet rs=preparedStmt.executeQuery();
		if (rs.next())
			id=rs.getInt(1);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
public int getId() {
	return id;
}
 
 
}

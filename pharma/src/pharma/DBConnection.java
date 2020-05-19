package pharma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Error in first");
			e.printStackTrace();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
		String  url ="jdbc:mysql://localhost:3306/pharma_management";
		try {
			con=DriverManager.getConnection(url,"user","user");
		} catch (SQLException e) {
			System.out.println("Error in second");
			e.printStackTrace();
		}
		return con;
	}

}

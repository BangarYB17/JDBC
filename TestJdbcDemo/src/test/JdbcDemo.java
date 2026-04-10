package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// step 1:Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2:create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			// step 3:create sql statement
			Statement st = con.createStatement();
			
			// step 4:Execute sql statement
			ResultSet rs = st.executeQuery("SELECT * FROM person");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+
						           rs.getString(2)+" "+
						           rs.getInt(3)
						);
			}
			
			// step 5: close connection
			con.close();
		} catch (Exception e) {
		    System.out.println(e);
		}
	}

}

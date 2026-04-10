package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class taskJdbc {

	public static void main(String[] args) {
		try {
			//step 1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2: create connection
			Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/javadb","root","root");
			
			//step 3: create statement
			Statement st = con.createStatement();
			
			//step 4: execute query
			ResultSet rs = st.executeQuery("select * from employees");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+
			                       rs.getString(2)+" "+
						           rs.getFloat(3)+" "+
			                       rs.getString(4)
						);
			}
			
			// step 5: close connection
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

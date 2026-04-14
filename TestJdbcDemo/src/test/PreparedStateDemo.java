package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into person values(?, ?, ?)");
			
			ps.setInt(1, 104);
			ps.setString(2, "Rohan");
			ps.setInt(3, 50);
			
			int i = ps.executeUpdate();
			System.out.println(i + " Record Inserted");
			
		    con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

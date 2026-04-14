package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			PreparedStatement ps = con.prepareStatement("select * from person");
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total Number of columns: "+rsmd.getColumnCount());
			System.out.println("Name of first column: "+rsmd.getColumnName(1));
			System.out.println("Datatype of first column: "+rsmd.getColumnTypeName(1));
			System.out.println("Size of second column: "+rsmd.getColumnDisplaySize(2));
			con.close();
		} catch (Exception e) {
			
		}

	}

}

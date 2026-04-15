package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			DatabaseMetaData dm = con.getMetaData();
			System.out.println("Driver Name: "+dm.getDriverName());
			System.out.println("Version Name: "+dm.getDriverVersion());
			System.out.println("Database Version: "+dm.getDatabaseProductVersion());
			System.out.println("Database Name: "+dm.getDatabaseProductName());
			System.out.println("URL Name: "+dm.getURL());
			System.out.println("Driver Major Version Name: "+dm.getDriverMajorVersion());
			System.out.println("Driver Minor Version Name: "+dm.getDriverMinorVersion());
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

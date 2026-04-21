package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PdfStoreDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into pdf_store(name,file)values(?,?)");
			ps.setString(1, "User");
		    
			FileInputStream input = new FileInputStream(new  File("C:\\jdbcimg\\user.pdf"));
			ps.setBlob(2, input);
			
			int rs = ps.executeUpdate();
			
			if(rs>0) {
				System.out.println("Data inserted successfully");
			}
			input.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BatchProcessiongDemo {

	public static void main(String[] args) {
		try {
			
			//Step 1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			con.setAutoCommit(false);
			
	/*		PreparedStatement ps = con.prepareStatement("insert into person values(?,?,?)");
			
			ps.setInt(1, 104);
			ps.setString(2, "Rohit");
			ps.setInt(3, 24);
			ps.addBatch();
			ps.execute(); */
			
			//Step 3 :Create Statement
			Statement st = con.createStatement();
			
			//Step 4: Prepare a Batch Processing
			st.addBatch("insert into person(id,name,age) values(104,'John',25)");
			st.addBatch("insert into person(id,name,age) values(105,'Prajay',23)");
			st.addBatch("insert into person(id,name,age) values(106,'Dipak',24)");
			st.addBatch("insert into person(id,name,age) values(107,'Harsh',22)");
			
			// Step 5:Exceute SQL Statement
			st.executeBatch();
			
			con.commit();
			System.out.println("Records Added Successfully.");
			//Step 6: Close Connection
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

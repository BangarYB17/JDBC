package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			con.setAutoCommit(false);
			
			Statement st = con.createStatement();
			st.addBatch("insert into employees(Emp_id,name,salary,email)values(105,'Rohit',40000.00,'rohit@gmail.com')");
			st.addBatch("insert into employees(Emp_id,name,salary,email)values(106,'Sameer',46000.00,'sameer@gmail.com')");
			st.addBatch("insert into employees(Emp_id,name,salary,email)values(107,'anish',35000.00,'anish@gmail.com')");
			st.addBatch("insert into employees(Emp_id,name,salary,email)values(108,'anand',55000.00,'anand@gmail.com')");
			
			st.executeBatch();
			System.out.println("Record Added Successfully");
			
		    con.commit();
		    
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

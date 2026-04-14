package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStateDemo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			CallableStatement cs = con.prepareCall("{call square_ofnum(?,?)}");		
			cs.setInt(1, 5);
			cs.registerOutParameter(2, Types.DOUBLE);
			
			cs.execute();
			System.out.println("Square of a no: "+cs.getDouble(2));
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

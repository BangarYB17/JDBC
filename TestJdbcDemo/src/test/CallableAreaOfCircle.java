package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableAreaOfCircle {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","root");
			
			CallableStatement cs = con.prepareCall("{call cal_area(?,?)}");
			cs.setDouble(1, 4.00);
			
			cs.registerOutParameter(2, Types.DOUBLE);
			
			cs.execute();
			System.out.println("Area of circle is: "+cs.getDouble(2));
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

package task;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo2 {

	public static void main(String[] args) {
		try {
			CachedRowSet rowset = RowSetProvider.newFactory().createCachedRowSet();
			
			rowset.setUrl("jdbc:mysql://localhost:3306/javadb");
			rowset.setUsername("root");
			rowset.setPassword("root");
			
			rowset.setCommand("select * from employees");
			
			rowset.execute();
			
			while(rowset.next()) {
				System.out.println(rowset.getInt(1)+" , "+
			                       rowset.getString(2)+" , "+
			                       rowset.getFloat(3)+" , "+
			                       rowset.getString(4));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

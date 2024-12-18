package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityExcepetion;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done and Sucess");
			System.out.println("Rowns Affected: " + rowsAffected);
		} 
		catch (SQLException e) {
			throw new DbIntegrityExcepetion(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
 		
	
	}
}

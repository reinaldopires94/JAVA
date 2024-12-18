package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbExceptoion;
import db.DbIntegrityExcepetion;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 2900 "
					+ "WHERE DepartmentId = 1"		
					);
			/*
			int x = 1;
			
			if(x < 2) {
				throw new SQLException("--Fake error--");
			}
			*/
			
			int rows2 = st.executeUpdate(
					"UPDATE seller "
					+ "SET BaseSalary = 3900 "
					+ "WHERE DepartmentId = 2"		
					);
			conn.commit();
			
			System.out.println("Done and Sucess");
			System.out.println("Affected Rows 'Department = 1' " + rows1);
			System.out.println("Affected Rows 'Department = 1' " + rows2);
			
		
		} catch (SQLException e) {
			//throw new DbIntegrityExcepetion(e.getMessage());
			//e.printStackTrace();
			try {
				conn.rollback();
				throw new DbExceptoion("Transaction rolled back! Cased by: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DbExceptoion("Erro trying to rollack: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
 		
	
	}
}

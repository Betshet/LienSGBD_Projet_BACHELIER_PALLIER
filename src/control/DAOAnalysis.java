package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Analysis;
import model.User;

public class DAOAnalysis {

	public DAOAnalysis() {
		
	}
	
	public ArrayList<Object> getAllAnalysis() {
		
		ArrayList<Object> anaList = new ArrayList<Object>();
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT * FROM medical_tests;");
				while(rs.next()) {
					anaList.add(new Analysis(
							rs.getString("test_name"),
							rs.getInt("time_taken_minutes")
							));		
				}				
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();
		return anaList;
	}
}

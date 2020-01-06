package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Analysis;
import model.Doctor;
import model.User;
import view.*;

public class DAODoc {
	
	public DAODoc() {
		
	}
	
	
	public Doctor GetDocInfoByMail(String mail) {
		//GET FROM BDD HERE

		Doctor doctor;
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT * FROM doctor WHERE mail='"+mail+"'");
				rs.next();
				doctor = new Doctor(rs.getString("name"),rs.getString("Surname"),rs.getString("SSNB"),mail,rs.getInt("Salary"));
		
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
			doctor = null;
		}
		dbAccess.Close();
		return doctor;
	}
	
	
	
	public void LogDoc() {
		LogInPop logpop = new LogInPop();
		
		ArrayList<String> mailList = new ArrayList<String>();
		//GET EMAIL LIST
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT Mail FROM doctor");
				while (rs.next()) {
					mailList.add(rs.getString("Mail"));
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();
		
		//WHAT TO DO WITH MAIL LIST
		
		if(logpop.getMailField().getText().equals("admin"))
		{
			
		}
		else
		{
			SimplePopup error = new SimplePopup("Error","Error Login");
		}
		
	}
	
	public ArrayList<Doctor> getAuthorizedDocs(Analysis ana){
		
		ArrayList<Doctor> docList = new ArrayList<Doctor>();
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT * FROM  authorizations INNER JOIN doctor WHERE test_name = '"+ana.toString()+"';");
				while (rs.next()) {
					docList.add(new Doctor(rs.getString("Name"),rs.getString("Surname"),rs.getString("SSNB"),rs.getString("Mail"),rs.getFloat("Salary")));
				}
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();
		return docList;
	}
}

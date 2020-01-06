package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import view.*;
import view.User.*;
public class DAOUser {

	public DAOUser() {
		
	}
	
	public void EnterUserInfo() {
		UserPopSign userpop = new UserPopSign();
		boolean dataIsCorrect = true;
		
		User user = new User(
				userpop.getNameField().getText(),
				userpop.getSurnameField().getText(),
				userpop.getSsnbField().getText(),
				userpop.getAddressField().getText(),
				userpop.getMailField().getText()
				);
				
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT `SSNB`,`Mail` "
								+ "FROM user "
								+ "WHERE SSNB='"+user.getSsnb()+"' "
										+ "OR Mail='"+user.getMail()+"'");
				
				if(rs.next())
				{
					if(rs.getString("SSNB").equals(user.getMail()))
					{
						new SimplePopup("error","sign in error : ssnb already used");
						dataIsCorrect=false;
					}
					else if(rs.getString("Mail").equals(user.getMail()))
					{
						new SimplePopup("error","sign in error : mail already used");
						dataIsCorrect=false;
					}
					
				}
				else if(user.getMail().equals(""))
				{
					new SimplePopup("Error","Sign in error : null value");
					dataIsCorrect=false;
				}
				
				dbAccess.Close();
				
				if(dataIsCorrect)
				{
					//insert into DB
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
					String query = "INSERT INTO user VALUES (?,?,?,?,?);";
					System.out.println(query);
					System.out.println(user.getMail());
					PreparedStatement statement =  conn.prepareStatement(query);
					statement.setString(1, user.getName());
					statement.setString(2, user.getSurname());
					statement.setString(3, user.getSsnb());
					statement.setString(4, user.getAddress());
					statement.setString(5, user.getMail()); //configure db to handle authorizations and correct names
					System.out.println(statement.toString());
					statement.execute();
					conn.close();
					new SignInConfirm(userpop.getNameField().getText());
				}
				
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		
	}
	
	public ArrayList<String> getMailList() {
		
		ArrayList<String> mailList = new ArrayList<String>();

		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT Mail FROM user");
				while (rs.next()) {
					mailList.add(rs.getString("Mail"));
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();
		return mailList;	
	}
	
	public User GetUserInfoByName(String name) {
		//GET FROM BDD HERE
		User user = new User();
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT * FROM user WHERE name='"+name+"'");
				rs.next();
				user.setName(name);
				user.setSurname(rs.getString("Surname"));
				user.setSsnb(rs.getString("SSNB"));
				user.setAddress(rs.getString("Adress"));
				user.setMail(rs.getString("Mail"));
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();

		
		
		return user;
	}
	

	public User GetUserInfoByMail(String mail) {
		User user = new User();
		DatabaseAccess dbAccess = new DatabaseAccess("sgbdprojet","root","");
		try {
				ResultSet rs = dbAccess.getInstruction()
						.executeQuery("SELECT * FROM user WHERE mail='"+mail+"'");
				rs.next();
				user.setName(rs.getString("Name"));
				user.setSurname(rs.getString("Surname"));
				user.setSsnb(rs.getString("SSNB"));
				user.setAddress(rs.getString("Adress"));
				user.setMail(mail);
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		dbAccess.Close();		
		
		return user;
	}
	
}

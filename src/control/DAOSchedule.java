package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import model.*;

public class DAOSchedule {
	
	public DAOSchedule() {
		
	}
	
	public static void insertSchedule(Timestamp meetingDate,Doctor metDoctor, User patient, boolean paid, Analysis type)
	{
		Schedule appointment = new Schedule(metDoctor,meetingDate,patient,paid,type);
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			String query = "INSERT INTO schedule"
					+ " VALUES (?,?,?,?,?)";
			PreparedStatement statement =  conn.prepareStatement(query);
			statement.setString(1, metDoctor.getMail());
			statement.setTimestamp(2,appointment.getDate());
			statement.setString(3, patient.getMail());
			statement.setBoolean(4, paid);
			statement.setString(5, type.toString()); //configure db to handle authorizations and correct names
			statement.execute();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
	
	public Timestamp insertFirstAvalaibleSchedule(ArrayList<Doctor> authorizedDoctors, Analysis type, User patient)
	{
		Schedule appointment = new Schedule();
		ArrayList<String> bufferDoctorName= new ArrayList<String>();
		ArrayList<Timestamp> latestDates= new ArrayList<Timestamp>();
		ArrayList<Integer> latestTimeTaken= new ArrayList<Integer>();
		ArrayList<String> bufferType= new ArrayList<String>();
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			
			//////////////////////
			String query = "SELECT doctor,MAX(date),t.time_taken_minutes, t.test_name\r\n" + 
					"FROM schedule \r\n" + 
					"INNER JOIN\r\n" + 
					"(SELECT *\r\n" + 
					" FROM medical_tests) AS t\r\n" + 
					" ON time_taken_minutes\r\n" + 
					"GROUP BY doctor";
			Statement statement =  conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				latestDates.add(rs.getTimestamp("MAX(date)"));
				bufferDoctorName.add(rs.getString("doctor"));
				latestTimeTaken.add(rs.getInt("time_taken_minutes"));
				bufferType.add(rs.getString("test_name"));
			}
			
			query = "SELECT COUNT(*) FROM doctor";
			rs=statement.executeQuery(query);
			int nbDocTotal=0;
			if(rs.next())
			{
				nbDocTotal=rs.getInt(1);
			}
			
			query = "SELECT COUNT(DISTINCT doctor) FROM schedule";
			rs=statement.executeQuery(query);
			int nbDoc=0;
			if(rs.next())
			{
				nbDoc=rs.getInt(1);
			}
			
			

			conn.close();
			
			
			Timestamp newAppointment = null;
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());			
			
			Timestamp earliestTime=Timestamp.valueOf("9999-01-01 00:00:00.0");
			String buffDoc=null;
			
			//buffdoc is the first doctor available at buffDate for buffType appointment
			for(int i=0;i<=latestDates.size()-1;i++)
			{
				latestDates.get(i).setTime(latestDates.get(i).getTime() + TimeUnit.MINUTES.toMillis(latestTimeTaken.get(i)));
				if(latestDates.get(i).before(earliestTime))
				{	
					earliestTime=latestDates.get(i);
					buffDoc=bufferDoctorName.get(i);
				}
				
			}
			Doctor bestDoctor=new Doctor();
			DAODoc daoDoc=new DAODoc();
			if( earliestTime.equals(Timestamp.valueOf("9999-01-01 00:00:00.0")))
			{
				earliestTime=currentTime;
				buffDoc=authorizedDoctors.get(0).getMail();
				bestDoctor= authorizedDoctors.get(0);
				newAppointment = currentTime;
			}
			if(earliestTime.before(currentTime))
			{
				if(nbDocTotal!=nbDoc)
				{
					buffDoc=authorizedDoctors.get(nbDoc).getMail();
					bestDoctor=daoDoc.GetDocInfoByMail(buffDoc);
				}
				else
				{
					bestDoctor=daoDoc.GetDocInfoByMail(buffDoc);
				}
				
				newAppointment = currentTime;
			}
			else if(earliestTime.after(currentTime))
			{
				if(nbDocTotal!=nbDoc)
				{
					buffDoc=authorizedDoctors.get(nbDoc).getMail();
					bestDoctor=daoDoc.GetDocInfoByMail(buffDoc);
					newAppointment = currentTime;
				}
				else
				{
					bestDoctor=daoDoc.GetDocInfoByMail(buffDoc);
					newAppointment = earliestTime;
				}
				
			}
		
			
			//doctor=daodoc.GetDocInfoByName("Ferrari");
			insertSchedule(newAppointment,bestDoctor, patient, false, type);//utilise la mail au lieu du name, ce qui cause une empty error
			return newAppointment;
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
			return null;
		}
		
	}
	
	
	public Object[][] getScheduleStrings(User user)
	{
		Object[][] schedList = new Object[count()][4];
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			
		
			String query = "SELECT name, date, type, paid "
					+ "FROM schedule "
					+ "INNER JOIN doctor "
					+ "ON schedule.doctor = doctor.mail "
					+ "WHERE schedule.user = '"+user.getMail()+"';";
			Statement statement =  conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			int i = 0;
			while(rs.next()) {
				schedList[i][0] = rs.getString("name");
				schedList[i][1] = rs.getString("date");
				schedList[i][2] = rs.getString("type");
				if(rs.getBoolean("paid"))
					schedList[i][3] = "Yes";
				else schedList[i][3] = "No";
				i++;
			}
					
			conn.close();
			
			return schedList;
			
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
			return null;
		}
	}
	
	public int count() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			
			String query = "SELECT COUNT(*) FROM schedule;";
			Statement statement =  conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			int ret = rs.getInt("COUNT(*)");
			conn.close();
			
			return ret;
			
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
			return 0;
		}
	}
	
	public void payVisit(User user, String date) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbdprojet?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			
			String query = "UPDATE schedule SET paid = 1 WHERE user = '"+user.getMail()+"' AND date = '"+date+"';";
			Statement statement =  conn.createStatement();
			statement.executeUpdate(query);

			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
}

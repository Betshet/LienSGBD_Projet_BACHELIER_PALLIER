package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import model.Analysis;
import model.Doctor;
import model.Schedule;
import model.User;
import view.*;
import view.User.UserLogged;
import view.User.UserMain;
import view.User.UserPopBook;
import view.User.UserPopPayInfo;
import view.User.UserTable;

public class ControlMain {
	
	public ControlMain() {
		
	}
	
	public void Launch() {
		MainWindow mainwindow = new MainWindow();
		mainwindow.afficher();
	}
	
	public void userLaunch() {
		UserMain user = new UserMain();
		user.afficher();
	}
	
	public User LogUser() {
		LogInPop logpop = new LogInPop();
		DAOUser daouser = new DAOUser();
		ArrayList<String> mailList = daouser.getMailList();
		
		for(String str : mailList) {
			if(logpop.getMailField().getText().equals(str))
			{
				return daouser.GetUserInfoByMail(logpop.getMailField().getText());
			}
		}
		return null;
		
	}
	
	public void userLogged(User user) {
		UserLogged userLog = new UserLogged(user);
		userLog.afficher();
	}
	
	public void logError() {
		SimplePopup error = new SimplePopup("Error","Login error");
	}
	
	public void BookAppointment(User user) {
		//get l'analyse
		Analysis ana = analysisInput();
		
		//get la liste des medecins autorisés pour l'analyse
		DAODoc daodoc = new DAODoc();
		ArrayList<Doctor> docList = daodoc.getAuthorizedDocs(ana);
		for(Doctor doc : docList) {
			System.out.println( doc.getName());
		}
		//insert into doc schedule
		DAOSchedule daosched = new DAOSchedule();
		
		new SimplePopup("Success","Appointment booked for "+daosched.insertFirstAvalaibleSchedule(docList, ana, user).toString());
	
	}
	
	public Analysis analysisInput() {
		DAOAnalysis daoana = new DAOAnalysis();
		UserPopBook popbook = new UserPopBook(daoana.getAllAnalysis());
		return (Analysis) popbook.getComboBox().getSelectedItem();
		
	}
	
	public void TableLaunch(User user) {
		UserTable table = new UserTable(user);
		table.afficher();
	}
	
	public void pay(User user, String date) {
		UserPopPayInfo payinfo = new UserPopPayInfo();
		PaymentService payserv = new PaymentService();
		if(payserv.pay(payinfo.getCreditCardNumber().getText(),payinfo.getSecretCode().getText())) {
			DAOSchedule sched = new DAOSchedule();
			sched.payVisit(user, date);
			new SimplePopup("Success","Visit paid");
		}
		else
		{
			new SimplePopup("Error","Error during payment");
		}
		TableLaunch(user);
		
	}
}

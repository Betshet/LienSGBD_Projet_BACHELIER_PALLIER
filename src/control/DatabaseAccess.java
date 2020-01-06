package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//DOES NOT WORK WITH PREPARED STATEMENTS
public class DatabaseAccess {
	private Connection conn;
	private Statement statement;
	
	public DatabaseAccess() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgbd_loo?serverTimezone=UTC", "root", "");
			System.out.println("Connected !");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		} 
	}
	
	public DatabaseAccess(String db,String username, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db+"?serverTimezone=UTC", username, password);
			System.out.println("Connected !");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		} 
	}
	
	public void Close() {
		System.out.println("Connection ended !");
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex3) {
			}
		}
	}
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getInstruction() {
		return statement;
	}

	public void setInstruction(Statement statement) {
		this.statement = statement;
	}
}
package br.com.Univercode.WebStudy.dao;

import java.sql.Connection;
import java.sql.DriverManager;




public class MyConnection {

	public static Connection getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			String server = "localhost";
			String user = "postgres";
			String password = "123";
			String database = "db_web_study";
			Connection conn = DriverManager.getConnection("jdbc:postgresql://"+server+"/"+database, user, password);
			return conn;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

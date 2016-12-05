package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataBase {

	public String login;
	public String password;
	public String dbname;
	public String host;
	
	private static final String DRIVER = "org.postgresql.Driver"; 
	
	Logger logger = Logger.getLogger(getClass());
	
	Connection conn;
	
	public DataBase(String login, String password, String dbname, String host) {
		this.login = login;
		this.password = password;
		this.dbname = dbname;
		this.host = host;
//		init();
//		loadDriver();
	}
	
	public void loadDriver(){
		try {
			Class.forName(DRIVER);
			logger.info(" Драйвер загружен");
		} catch (ClassNotFoundException e) {
			logger.error(" Драйвер не загружен" + e.getMessage());
		}
	}
	
	public Connection getConnection(){
		String jdbcURL = "jdbc:postgresql://" + host + ":5432/" + dbname;
		try {
			logger.info(" Подключение к базе данных " + dbname + "...");
			Connection conn = DriverManager.getConnection(jdbcURL, login , password);
			logger.info("Успешно!");
			return conn;
		} catch (SQLException e) {
			logger.error("Нет подключения к БД " + e.getMessage());
		}
		return null;
	}
}

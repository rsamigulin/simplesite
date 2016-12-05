package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PageDescription {

	DataBase database;
	Connection conn;
	Logger logger = Logger.getLogger(PageDescription.class);
	
	public PageDescription(DataBase database) {
		this.database = database;
		this.conn = this.database.getConnection();
	}
	
	public String getPageContent(String pageName){
		String sql = "SELECT * FROM pages WHERE name = ?";
		String description = "";
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			conn.setAutoCommit(false);
//			logger.info("Добавление новой записи...");
			ps.setString(1, pageName);
			ps.addBatch();
			conn.commit();
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				description = rs.getString("description");
			
		} catch (SQLException e) {
			logger.error("Выбор записей - неудачно! " + e.getMessage());
			try {
				if(conn != null)
					conn.rollback();
			} catch (SQLException sqle) {
				logger.error("Выбор записей , откат неудачно! " + sqle.getMessage() + e.getStackTrace() );
			}
		}
		
		return description;
	}
}

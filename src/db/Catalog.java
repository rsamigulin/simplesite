package db;

//import static java.sql.Statement.RETURN_GENERATED_KEYS;
//import static util.sql.TransactionManager.getTxConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

import servlet.InitApp;



public class Catalog {

	DataBase database;
	Connection conn;
	
	public Catalog(DataBase database) {
		this.database = database;
		this.conn = this.database.getConnection();

	}
	
//	public Catalog(String login, String password, String dbname, String host) {
//		super(login, password, dbname, host);
//	}

	Logger logger = Logger.getLogger(Catalog.class);
	
	public CopyOnWriteArrayList<Product> getProducts(){
		String sql = "SELECT * FROM catalog";
		
		CopyOnWriteArrayList<Product> catalog = new CopyOnWriteArrayList<>();
		try (Statement st = conn.createStatement()){
			conn.setAutoCommit(false);
			st.execute(sql);
			conn.commit();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()){
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String imageName = rs.getString("image");
				int quantity = rs.getInt("quantity");
				Product product = new Product(name, description, price, imageName, quantity);
				catalog.add(product);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			try {
				if(conn != null)
					conn.rollback();
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage() + e.getStackTrace() );
			}
		}
		
		return catalog;
	}
	
	public CopyOnWriteArrayList<Product> getProductsWithLimitOffset(int limit, int offset){
		String select = "SELECT * FROM catalog ORDER BY name ASC LIMIT ? OFFSET ? ";
		CopyOnWriteArrayList<Product> catalog = new CopyOnWriteArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(select)){
			conn.setAutoCommit(false);
//			logger.info("Добавление новой записи...");
			ps.setInt(1, limit);
			ps.setInt(2, offset);
//			ps.execute();
			ps.addBatch();
//			int[] count = ps.executeBatch();
			conn.commit();
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String imageName = rs.getString("image");
				int quantity = rs.getInt("quantity");
				Product product = new Product(name, description, price, imageName, quantity);
				catalog.add(product);
			}
			
//			logger.info("Добавление новой записи - успешно.");
//			logger.info("Количество - " + count.length);
			
		} catch (SQLException e) {
			logger.error("Выбор " + limit + " записей - неудачно! " + e.getMessage());
			try {
				if(conn != null)
					conn.rollback();
			} catch (SQLException sqle) {
				logger.error("Добавление новой записи , откат неудачно! " + sqle.getMessage() + e.getStackTrace() );
			}
		}
		
		
		return catalog;
		
		
		
	}
}

package servlet;


//import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import app.App;
import db.DataBase;


@SuppressWarnings("serial")
public class InitApp extends HttpServlet {
	
	Logger logger = Logger.getLogger(InitApp.class);
	
	@Override
	public void init() throws ServletException {
		try {
			
			ServletContext sc = getServletContext();
			
			App app = createApp("postgres", "1q2w3e4R", "simplesite", "localhost");
			sc.setAttribute("app", app);
//			sc.setAttribute("db", app.getDatabase());
			
		}catch (Exception e) {
			throw new ServletException("can't init", e);
		}
	}
	
	public static App createApp(String login, String password, String dbname, String host) throws IOException{
		
		DataBase db = new DataBase(login, password, dbname, host);
		
		App app = new App();
		db.loadDriver();
		app.init(db);
		
		return app;
	}
}

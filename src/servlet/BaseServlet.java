package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import app.App;


public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected App app;
	//protected Database app;
	
	@Override
	public void init() throws ServletException {
		
		ServletContext sc = getServletContext();
		app = (App)sc.getAttribute("app");
//		db = (App)sc.getAttribute("db");
		System.out.println("BaseServlet");
	}
}

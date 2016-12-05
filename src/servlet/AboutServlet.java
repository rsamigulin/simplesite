package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.PageDescription;

public class AboutServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PageDescription pageDescription = app.getPageDescription();
		
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("contextPath", req.getContextPath());
		req.setAttribute("pageDescription", pageDescription.getPageContent("about"));
		
		req.getRequestDispatcher("/WEB-INF/about.jsp").forward(req, resp);
	}
}

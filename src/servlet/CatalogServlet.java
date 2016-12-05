package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Catalog;
import db.PageDescription;
import db.Product;
import util.Util;

public class CatalogServlet extends BaseServlet {

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
		req.setCharacterEncoding("UTF-8");
		
		int limit = Util.tryParseInt(req.getParameter("limit"), 10);
		int offset = Util.tryParseInt(req.getParameter("offset"), 0);
		
		Catalog catalog = app.getCatalog();
		PageDescription pageDescription = app.getPageDescription();
		
//		CopyOnWriteArrayList<Product> list = catalog.getProducts();
		CopyOnWriteArrayList<Product> listForPagination = catalog.getProductsWithLimitOffset(limit, offset);
		
		req.setAttribute("pageDescription", pageDescription.getPageContent("catalog"));
//		req.setAttribute("products", list);
		req.setAttribute("productsWithPagination", listForPagination);
		req.setAttribute("contextPath", req.getContextPath());
		req.setAttribute("limit", limit);
		req.setAttribute("offset", offset);
		
		req.getRequestDispatcher("/WEB-INF/catalog.jsp").forward(req, resp);
	}
}

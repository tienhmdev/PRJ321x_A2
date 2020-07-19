package funix.edu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Page;
import funix.edu.models.PageRequest;

public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("home");
		try {
			Page productPage = new ProduceDao(DatabaseManager.getConnection()).getProduPage(new PageRequest(1, 8));
			request.getSession().setAttribute("products", productPage.getProducts());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("error");
		}
		request.getRequestDispatcher("home.html").forward(request, response);
	}

}

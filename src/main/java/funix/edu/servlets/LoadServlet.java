package funix.edu.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Brand;

public class LoadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProduceDao produceDao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("redirect");
		Connection connection = null;
		try {
			connection = DatabaseManager.getConnection();
			produceDao = new ProduceDao(connection);
			List<Brand> brands = produceDao.getBrands(connection);
			HttpSession session = request.getSession();
			session.setAttribute("brands", brands);
			System.out.println("Brand size: " + brands.size());
			if (brands.size() <= 0) {
				response.sendRedirect("redirecting");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("redirecting");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("redirecting");
		}finally {
			DatabaseManager.closeConnection(connection);
		}
		response.sendRedirect("home");
	}

}

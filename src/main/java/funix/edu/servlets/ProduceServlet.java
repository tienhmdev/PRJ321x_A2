package funix.edu.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Products;

public class ProduceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProduceDao productDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String productId = req.getParameter("id");
			productDao = new ProduceDao(DatabaseManager.getConnection());
			Products product = productDao.getProductByProductId(Integer.parseInt(productId));
			System.out.println("prduc name: " + product.getProductName());
			HttpSession session = req.getSession();
			session.setAttribute("product", product);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("produce.html").forward(req, resp);
	}
}

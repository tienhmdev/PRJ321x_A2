package funix.edu.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Products;

public class CheckoutServlet extends HttpServlet{
	public static final int CHECKOUT_SINGLE = 1;
	public static final int CHECKOUT_CART = 0;
	private static final long serialVersionUID = 1L;
	private ProduceDao productDao;
	private Connection connection;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String productId = req.getParameter("id");
			HttpSession session = req.getSession();
			if (productId != null) {
				connection = DatabaseManager.getConnection();
				productDao = new ProduceDao(connection);
				Products product = productDao.getProductByProductId(Integer.parseInt(productId));
				session.setAttribute("product", product);
				session.setAttribute("checkoutType", CHECKOUT_SINGLE);
			}else {
				session.setAttribute("checkoutType", CHECKOUT_CART);
			}
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
		req.getRequestDispatcher("checkout.html").forward(req, resp);
	}
}

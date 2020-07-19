package funix.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import funix.edu.context.DatabaseManager;
import funix.edu.context.EcommerceDAO;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Products;

public class CartServlet extends HttpServlet {
	private Connection connection;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("cart.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.connection = DatabaseManager.getConnection();
			@SuppressWarnings("unchecked")
			List<Products> carts = (List<Products>) req.getSession().getAttribute("carts");
			if (carts == null) {
				carts = new ArrayList<Products>();
			}
			
			JSONObject responseJson = new JSONObject();
			
			StringBuffer json = new StringBuffer();
			json.append(req.getReader().readLine());
			JSONObject objProduct = new JSONObject(json.toString());
			int productId = objProduct.getInt("productId");
			String status = objProduct.getString("status");
			
			switch (status) {
			case "update":
				System.out.println("update");
				responseJson.put("totalCart", carts.size());
				break;
			case "insert":
				System.out.println("insert");
				Products product = new ProduceDao(connection).getProductByProductId(productId);
				if (product != null) {
					carts.add(product);
				}
				responseJson.put("totalCart", carts.size());
				break;
			default:
				break;
			}
			
			req.getSession().setAttribute("carts", carts);
			int totalPrice = 0;
			for (Products product : carts) {
				totalPrice += Integer.parseInt(product.getProducePrice().replace(",", ""));
			}
			req.getSession().setAttribute("totalPriceOnCart", EcommerceDAO.formatPrice(EcommerceDAO.PRODUCT_PRICE_PATTERN, totalPrice));
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.append(responseJson.toString());
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("err");
			e.printStackTrace();
			response.setStatus(500);
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.append("{}");
			writer.close();
		}
	}
}

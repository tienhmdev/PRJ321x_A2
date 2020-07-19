package funix.edu.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.OrderDao;
import funix.edu.dao.OrderDetailDao;
import funix.edu.models.Orders;
import funix.edu.models.OrdersDetail;
import funix.edu.models.Products;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	Connection connection;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.connection = DatabaseManager.getConnection();

			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			int checkoutType = (int) request.getSession().getAttribute("checkoutType");
			Orders order = new Orders(email, address);
			order.setOrderDiscountCode(name);
			int orderId = new OrderDao(connection).saveOrder(order);
			if (orderId != -1) {
				List<OrdersDetail> ordersDetails = new ArrayList<OrdersDetail>();
				// check type checkout
				switch (checkoutType) {
				case CheckoutServlet.CHECKOUT_SINGLE:
					Products product = (Products) request.getSession().getAttribute("product");
					OrdersDetail ordersDetail = new OrdersDetail(orderId, product.getProductId(),
							product.getProducePrice());
					ordersDetails.add(ordersDetail);
					System.out.println("check out single");
					break;
				case CheckoutServlet.CHECKOUT_CART:
					@SuppressWarnings("unchecked") List<Products> cartList = (List<Products>) request.getSession().getAttribute("carts");
					for (Products prd : cartList) {
						OrdersDetail od = new OrdersDetail(orderId, prd.getProductId(), prd.getProducePrice());
						ordersDetails.add(od);
					}
					System.out.println("check out carts");
					// clear cart
					request.getSession().setAttribute("carts", new ArrayList<Products>());
					break;
				default:
					break;
				}
				
				if (!ordersDetails.isEmpty()) {
					System.out.println("start save!");
					new OrderDetailDao(connection).saveOrderDetails(ordersDetails);
				}else {
					System.out.println("save err ===>");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error ==================.");
		}
		System.out.println("thankyou ==================.");
		response.sendRedirect("thankyou");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

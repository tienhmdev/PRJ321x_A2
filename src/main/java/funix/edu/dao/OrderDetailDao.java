package funix.edu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import funix.edu.context.EcommerceDAO;
import funix.edu.models.OrdersDetail;

public class OrderDetailDao extends EcommerceDAO{
	private Connection connection;
	
	public OrderDetailDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void saveOrderDetails(List<OrdersDetail> ordersDetails) throws SQLException {
		super.saveOrderDetails(connection, ordersDetails);
	}
}

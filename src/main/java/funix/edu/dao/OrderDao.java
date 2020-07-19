package funix.edu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import funix.edu.context.EcommerceDAO;
import funix.edu.models.Orders;

public class OrderDao extends EcommerceDAO{
	private Connection connection;
	
	public OrderDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public int saveOrder(Orders orders) throws SQLException {
		return super.saveOrder(connection, orders);
	}
}

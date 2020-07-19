package funix.edu.context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import funix.edu.commonUtils.SQLQueries;
import funix.edu.models.Brand;
import funix.edu.models.Orders;
import funix.edu.models.OrdersDetail;
import funix.edu.models.Page;
import funix.edu.models.PageRequest;
import funix.edu.models.Products;

public class EcommerceDAO {
	public static final String PRODUCT_PRICE_PATTERN = "##,###,###";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = DatabaseManager.getConnection();
		EcommerceDAO ecommerceDAO = new EcommerceDAO();
		//Orders orders = new Orders("tienabc@gmail.com", "0123456789", "hue");
		OrdersDetail ordersDetail1 = new OrdersDetail(2, 6, "22,000,000");
		OrdersDetail ordersDetail2 = new OrdersDetail(2, 6, "23,000,000");
		List<OrdersDetail> ordersDetails = new ArrayList<>();
		ordersDetails.add(ordersDetail1);
		ordersDetails.add(ordersDetail2);
		//ecommerceDAO.saveOrder(connection, orders);
		ecommerceDAO.saveOrderDetails(connection, ordersDetails);
	} 
	
	/* GET ALL PRODUCT */
	public Page getProducts(Connection connection, PageRequest pageRequest) throws SQLException {
		Page page = new Page(pageRequest.getCurrentPage(), pageRequest.getSizeOfPage());
		String sqlQuery = SQLQueries.COUNT_ALL_PRODUCTS;
		PreparedStatement statement = connection.prepareStatement(sqlQuery,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		updateTotalPage(connection, page, statement);
		System.out.println("totalPage: " + page.getTotalPage());
		
		String sqlQueryProducts = SQLQueries.SELECT_ALL_PRODUCTS;
		PreparedStatement statementProducts = connection.prepareStatement(sqlQueryProducts,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		statementProducts.setInt(1, (page.getCurrentPage()-1)*page.getSizeOfPage());
		statementProducts.setInt(2, page.getSizeOfPage());
		updateProducts(connection, page, statementProducts);
		System.out.println("totalSize: " + page.getProducts().get(0).getProductId());
		return page;
	}
	
	
	/* SEARCH PRODUCTS BY BRAND AND KEYWORD */
	public Page getProducts(Connection connection, PageRequest pageRequest,String keyword, int brandId) throws SQLException {
		Page page = new Page(pageRequest.getCurrentPage(), pageRequest.getSizeOfPage());
		PreparedStatement statement = connection.prepareStatement(SQLQueries.COUNT_PRODUCTS_MATCH_KEYWORD_AND_BRAND,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		statement.setInt(1, brandId);
		statement.setString(2, "%" + keyword + "%");
		updateTotalPage(connection, page, statement);
		System.out.println("totalPage: " + page.getTotalPage());
				PreparedStatement statementProducts = connection.prepareStatement(SQLQueries.SEARCH_PAGE_PRODUCTS_BY_KEYWORD_AND_BRAND,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		statementProducts.setInt(1, brandId);
		statementProducts.setString(2, "%" + keyword + "%");
		statementProducts.setInt(3, (page.getCurrentPage()-1)*page.getSizeOfPage());
		statementProducts.setInt(4, page.getSizeOfPage());
		updateProducts(connection, page, statementProducts);
		return page;
	}
	
	
	/* GET PRODUCT BY PRODUCT ID */
	public Products getProductById(Connection connection, int productId) throws SQLException {
		Products product = new Products();
		String sqlQuery = SQLQueries.SELECT_SINGLE_PRODUCT;
		PreparedStatement statement = connection.prepareStatement(sqlQuery,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		statement.setInt(1, productId);
		ResultSet resultSet = statement.executeQuery();
		resultSet.beforeFirst();
		while (resultSet.next()) {
			System.out.println("row: " + resultSet.getRow());
			product.setProductId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setProductDes(resultSet.getString(3));
			product.setProducePrice(formatPrice(PRODUCT_PRICE_PATTERN, resultSet.getInt(4)));
			product.setProductImageSouce(resultSet.getString(5));
			product.setProductType(resultSet.getString(6)); 
			product.setProductBrand(resultSet.getInt(7));
		}
		return product;
	}
	
	
	/* GET ALL BRAND */
	public List<Brand> getBrands(Connection connection) throws SQLException {
		List<Brand> brands = new ArrayList<Brand>();
		String sqlQuery = SQLQueries.SELECT_ALL_BRAND;
		PreparedStatement statement = connection.prepareStatement(sqlQuery,   ResultSet.TYPE_SCROLL_INSENSITIVE, 
				  ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery();
		resultSet.beforeFirst();
		while (resultSet.next()) {
			Brand brand = new Brand();
			brand.setBrandId(resultSet.getInt(1));
			brand.setBrandName(resultSet.getString(2));
			brands.add(brand);
		}
		return brands;
	}
	
	
	/* SAVE ORDER */
	public int saveOrder(Connection connection, Orders orders) throws SQLException {
		String sqlQuery = SQLQueries.INSERT_ORDER;
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, orders.getUserMail());
		statement.setString(2, orders.getOrderDiscountCode());
		statement.setString(3, orders.getOrderAddress());
		if (!statement.execute()) {
			String sqlQueryId = SQLQueries.SELECT_NEWLY_RECORD;
			PreparedStatement statementId = connection.prepareStatement(sqlQueryId, ResultSet.TYPE_SCROLL_INSENSITIVE, 
					  ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statementId.executeQuery();
			resultSet.beforeFirst();
			if (resultSet.next()) {
				return resultSet.getInt(2);
			}
		}
		return -1;
	}
	
	/* SAVE ORDER DETAIL */
	public void saveOrderDetails(Connection connection, List<OrdersDetail> ordersDetails) throws SQLException {
		String sqlQuery = SQLQueries.INSERT_ORDER_DETAIL;
		for (OrdersDetail ordersDetail : ordersDetails) {
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, ordersDetail.getOrderId());
			statement.setInt(2, ordersDetail.getProductId());
			statement.setInt(3, Integer.parseInt(ordersDetail.getPriceProduce().replace(",", "")));
			statement.execute();
		}
	}
	
	private void updateProducts(Connection connection, Page page,PreparedStatement statement) throws SQLException {
		List<Products> products = new ArrayList<>(); 
		ResultSet resultSet = statement.executeQuery();
		resultSet.beforeFirst();
		while (resultSet.next()) {
			System.out.println("row: " + resultSet.getRow());
			Products product = new Products();
			product.setProductId(resultSet.getInt(1));
			product.setProductName(resultSet.getString(2));
			product.setProductDes(resultSet.getString(3));
			product.setProducePrice(formatPrice(PRODUCT_PRICE_PATTERN, resultSet.getInt(4)));
			product.setProductImageSouce(resultSet.getString(5));
			product.setProductType(resultSet.getString(6)); 
			product.setProductBrand(resultSet.getInt(7));
			products.add(product);
		}
		page.setProducts(products);
	}
	private void updateTotalPage(Connection connection, Page page, PreparedStatement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery();
		int total;
		resultSet.beforeFirst();
		if (resultSet.next()) {
			total = resultSet.getInt(1);
		}else {
			total = 0;
		}
		System.out.println("size: " + total);
		if (total%page.getSizeOfPage() == 0) {
			page.setTotalPage(total/page.getSizeOfPage());
		}else {
			page.setTotalPage(total/page.getSizeOfPage()+1);
		}
	}
	
	public static String formatPrice(String pattern, int price) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
	    return myFormatter.format(price);
	}
}

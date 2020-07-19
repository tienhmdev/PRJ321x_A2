package funix.edu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import funix.edu.context.EcommerceDAO;
import funix.edu.models.Brand;
import funix.edu.models.Page;
import funix.edu.models.PageRequest;
import funix.edu.models.Products;

public class ProduceDao extends EcommerceDAO{
	private Connection connection;
	
	
	public ProduceDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public Page getProduPage(PageRequest pageRequest) throws SQLException {
		return getProducts(connection, pageRequest);
	}
	public Products getProductByProductId(int productId) throws SQLException {
		return getProductById(connection, productId);
	}
	
	public Page getPageProductByKeywordAndBrand(PageRequest pageRequest, String keyword, int brandId) throws SQLException {
		return getProducts(connection, pageRequest, keyword, brandId);
	}
	
	public List<Brand> getBrands() throws SQLException{
		return getBrands(connection);
	}
}

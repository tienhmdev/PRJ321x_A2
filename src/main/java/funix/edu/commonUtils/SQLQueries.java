package funix.edu.commonUtils;

public class SQLQueries {
	public static final String SELECT_PAGE_PRODUCT_BY_BRAND = "SELECT [product_id] ,[product_name] ,[product_des] ,[product_price] ,[product_img_source] ,[product_type] ,[product_brand] FROM [dbo].[Products] p WHERE p.product_brand = ? ORDER BY (SELECT NULL)OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String SELECT_ALL_PRODUCT_BY_BRAND = "SELECT [product_id] ,[product_name] ,[product_des] ,[product_price] ,[product_img_source] ,[product_type] ,[product_brand] FROM [dbo].[Products] p WHERE p.product_brand = ?";
	public static final String COUNT_PRODUCTS_MATCH_KEYWORD_AND_BRAND = "SELECT COUNT(p.product_id) as totalProduct FROM [dbo].[Products] p WHERE p.product_brand = ? and p.product_name like ?";
	public static final String SEARCH_PAGE_PRODUCTS_BY_KEYWORD_AND_BRAND = "SELECT [product_id] ,[product_name] ,[product_des] ,[product_price] ,[product_img_source] ,[product_type] ,[product_brand] FROM [dbo].[Products] p WHERE p.product_brand = ? and p.product_name like ? ORDER BY (SELECT NULL)OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String COUNT_ALL_PRODUCTS = "SELECT COUNT(p.product_id) as totalProduct FROM Products p";
	public static final String SELECT_ALL_PRODUCTS = "SELECT [product_id] ,[product_name] ,[product_des] ,[product_price] ,[product_img_source] ,[product_type] ,[product_brand] FROM [dbo].[Products]ORDER BY (SELECT NULL)OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
	public static final String SELECT_SINGLE_PRODUCT = "SELECT [product_id] ,[product_name] ,[product_des] ,[product_price] ,[product_img_source] ,[product_type] ,[product_brand] FROM [dbo].[Products] p WHERE p.product_id = ?;";
	public static final String SELECT_ALL_BRAND = "SELECT [brand_id] ,[brand_name] FROM [dbo].[Brand]";
	public static final String SELECT_NEWLY_RECORD = "select top(1) * from Orders o order by o.order_id desc";
	
	/* INSERT QUERIES */
	public static final String INSERT_ORDER = "INSERT INTO [dbo].[Orders] ([user_mail] ,[order_status] ,[order_date] ,[order_discount_code] ,[order_address]) VALUES (? ,0 ,GETDATE() ,? ,?)";
	public static final String INSERT_ORDER_DETAIL = "INSERT INTO [dbo].[Orders_detail] ([order_id] ,[product_id] ,[amount_product] ,[price_product]) VALUES (? ,? ,1 ,?)";

}

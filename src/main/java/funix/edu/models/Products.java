package funix.edu.models;

public class Products {
	private int productId;
	private String productName;
	private String productDes;
	private String producePrice;
	private String productImageSouce;
	private String productType;
	private int productBrand;
	
	
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductDes() {
		return productDes;
	}
	public String getProducePrice() {
		return producePrice;
	}
	public String getProductImageSouce() {
		return productImageSouce;
	}
	public String getProductType() {
		return productType;
	}
	public int getProductBrand() {
		return productBrand;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}
	public void setProducePrice(String producePrice) {
		this.producePrice = producePrice;
	}
	public void setProductImageSouce(String productImageSouce) {
		this.productImageSouce = productImageSouce;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public void setProductBrand(int productBrand) {
		this.productBrand = productBrand;
	}
}

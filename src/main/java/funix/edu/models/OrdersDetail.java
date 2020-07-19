package funix.edu.models;

public class OrdersDetail {
 private int orderId;
 private int productId;
 private int amountProduct;
 private String priceProduce;

 public OrdersDetail(int orderId, int productId, String priceProduce) {
	super();
	this.orderId = orderId;
	this.productId = productId;
	this.priceProduce = priceProduce;
}
 
public OrdersDetail() {
	super();
}
public int getOrderId() {
	return orderId;
}
public int getProductId() {
	return productId;
}
public int getAmountProduct() {
	return amountProduct;
}
public String getPriceProduce() {
	return priceProduce;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public void setAmountProduct(int amountProduct) {
	this.amountProduct = amountProduct;
}
public void setPriceProduce(String priceProduce) {
	this.priceProduce = priceProduce;
}
 
}

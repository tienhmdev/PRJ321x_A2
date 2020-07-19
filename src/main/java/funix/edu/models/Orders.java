package funix.edu.models;

public class Orders {
	private String userMail;
	private int orderId;
	private int orderStatus;
	private String orderDate;
	private String orderDiscountCode;
	private String orderAddress;
	
	
	public Orders() {
		super();
	}
	
	public Orders(String userMail, String orderAddress) {
		super();
		this.userMail = userMail;
		this.orderAddress = orderAddress;
	}
	
	public Orders(String userMail, String orderDiscountCode, String orderAddress) {
		super();
		this.userMail = userMail;
		this.orderDiscountCode = orderDiscountCode;
		this.orderAddress = orderAddress;
	}

	public String getUserMail() {
		return userMail;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getOrderDiscountCode() {
		return orderDiscountCode;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
}

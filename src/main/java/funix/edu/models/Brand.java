package funix.edu.models;

public class Brand {
private int brandId;
private String brandName;
public synchronized int getBrandId() {
	return brandId;
}
public synchronized String getBrandName() {
	return brandName;
}
public synchronized void setBrandId(int brandId) {
	this.brandId = brandId;
}
public synchronized void setBrandName(String brandName) {
	this.brandName = brandName;
}


}

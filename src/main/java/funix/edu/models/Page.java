package funix.edu.models;

import java.util.List;

public class Page {
	private int currentPage;
	private int totalPage;
	private int sizeOfPage;
	private List<Products> products;
	
	public Page(int currentPage, int sizeOfPage) {
		super();
		this.currentPage = currentPage;
		this.sizeOfPage = sizeOfPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
}

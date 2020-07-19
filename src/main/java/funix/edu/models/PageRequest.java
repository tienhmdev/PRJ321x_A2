package funix.edu.models;
public class PageRequest{
	private int currentPage;
	private int sizeOfPage;
	public PageRequest(int currentPage, int sizeOfPage) {
		super();
		this.currentPage = currentPage;
		this.sizeOfPage = sizeOfPage;
	}
	public PageRequest() {
		super();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getSizeOfPage() {
		return sizeOfPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	
	
}
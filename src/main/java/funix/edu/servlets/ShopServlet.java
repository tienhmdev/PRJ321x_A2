package funix.edu.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funix.edu.context.DatabaseManager;
import funix.edu.dao.ProduceDao;
import funix.edu.models.Brand;
import funix.edu.models.Page;
import funix.edu.models.PageRequest;

public class ShopServlet extends HttpServlet{
	public Connection connection;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int brandId = Integer.valueOf(request.getParameter("brandId"));
			String keyword = request.getParameter("keyword");
			String currentPageString = request.getParameter("currentPage");
			String sizeOfPageString = request.getParameter("sizeOfPage");
			
			int currentPage, sizeOfPage;
			if (keyword == null) {
				keyword = "";
			}
			if (currentPageString == null) {
				currentPage = 1;
			}else {
				currentPage = Integer.valueOf(currentPageString);
			}
			if (sizeOfPageString == null) {
				sizeOfPage = 12;
			}else {
				sizeOfPage = Integer.valueOf(sizeOfPageString);
			}
			System.out.println("keyword: " + keyword);
			System.out.println("brandId: " + brandId);
			System.out.println("currentPage: " + currentPage);
			System.out.println("sizeOfPage: " + sizeOfPage);
			
			connection = DatabaseManager.getConnection();
			ProduceDao produceDao = new ProduceDao(connection);
			PageRequest pageRequest = new PageRequest(currentPage, sizeOfPage);
			Page page = produceDao.getPageProductByKeywordAndBrand(pageRequest, keyword, brandId);
			
			HttpSession session = request.getSession();
			session.setAttribute("products", page.getProducts());
			session.setAttribute("currentPage", page.getCurrentPage());
			session.setAttribute("sizeOfPage", page.getSizeOfPage());
			session.setAttribute("totalPage", page.getTotalPage());
			session.setAttribute("keyword", keyword);
			session.setAttribute("brandIdSelected", brandId);
			for (Brand br : (ArrayList<Brand>)session.getAttribute("brands")) {
				if (br.getBrandId() == brandId) {
					session.setAttribute("brandName", br.getBrandName());
				}
			}
			
			request.getRequestDispatcher("shop.html").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}
		
	}
}

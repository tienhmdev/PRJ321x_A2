package funix.edu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String email = getServletConfig().getInitParameter("email");
			String password = getServletConfig().getInitParameter("password");
			System.out.println("info: " + email + "/" + password);
			
			String inputEmail = req.getParameter("email").toLowerCase();
			String inputPassword = req.getParameter("password");
			
			if (inputEmail.equals(email) && inputPassword.equals(password)) {
				session.setAttribute("email", inputEmail);
				session.setAttribute("password", inputPassword);
				System.out.println("success");
				resp.sendRedirect("admin.html");
			}else {
				session.setAttribute("errorMessage", "Email or password is not correct!");
				System.out.println("error");
				resp.sendRedirect("login");
			}
		} catch (Exception e) {
			session.setAttribute("errorMessage", "Email or password is not correct!");
			System.out.println("error");
			resp.sendRedirect("login");
		}
	}
}

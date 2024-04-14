package org.unibl.etf.ip.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.ip.dao.UserDAO;
import org.unibl.etf.ip.dtos.User;
import org.unibl.etf.ip.utilities.PropertyLoader;
import static org.unibl.etf.ip.utilities.Constants.START_PAGE;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException
	{
		super.init();
		PropertyLoader.load(getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = START_PAGE + "login.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("notification", "");
		if (action == null || action.equals(""))
			address = START_PAGE + "login.jsp";
		else if (action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = UserDAO.getByUsernameAndPassword(username, password);
			if (user == null) {
				session.setAttribute("notification", "Invalid credentials");
			} else {
				address = START_PAGE + "menu.jsp";
				session.setAttribute("user", user);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

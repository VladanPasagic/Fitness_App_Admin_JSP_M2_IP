package org.unibl.etf.ip.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final String START_PAGE = "/WEB-INF/pages/";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = START_PAGE + "menu.jsp";
		String action = request.getParameter("action");
		if (action == null || action.equals(""))
			address = START_PAGE + "menu.jsp";
		else {
			if (action.equals("users")) {
				address = START_PAGE + "users.jsp";
			} else if (action.equals("stats")) {
				address = START_PAGE + "stats.jsp";
			} else if (action.equals("categories")) {
				address = START_PAGE + "categories.jsp";
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

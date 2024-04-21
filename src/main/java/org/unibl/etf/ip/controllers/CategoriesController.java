package org.unibl.etf.ip.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.ip.beans.CategoriesBean;
import org.unibl.etf.ip.beans.CategoryBean;
import org.unibl.etf.ip.dao.CategoryDAO;
import org.unibl.etf.ip.dao.SpecificAttributeDAO;
import org.unibl.etf.ip.dtos.Category;
import org.unibl.etf.ip.dtos.SpecificAttribute;

import static org.unibl.etf.ip.utilities.Constants.START_PAGE;

/**
 * Servlet implementation class CategoriesController
 */
@WebServlet("/CategoriesController")
public class CategoriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String address = START_PAGE + "categories.jsp";
		HttpSession session = request.getSession();
		CategoriesBean categoriesBean = new CategoriesBean();
		session.setAttribute("categoriesBean", categoriesBean);
		CategoryBean categoryBean = new CategoryBean(null);
		session.setAttribute("categoryBean", categoryBean);
		String action = request.getParameter("action");
		if (action == null || action.equals(""))
			address = START_PAGE + "categories.jsp";
		else if (action.equals("save")) {
			String[] keys = request.getParameterValues("key[]");
			String[] values = request.getParameterValues("value[]");
			String name = request.getParameter("categoryName");
			System.out.println(name);
			Category category = CategoryDAO.createCategory(name);
			List<SpecificAttribute> specificAttributes = new ArrayList<SpecificAttribute>();
			for (int i = 0; i < keys.length; i++) {
				specificAttributes.add(new SpecificAttribute(keys[i], values[i]));
			}
			SpecificAttributeDAO.saveAttributes(category.getId(), specificAttributes);
		} else if (action.equals("close")) {
			categoryBean = new CategoryBean(null);
			session.setAttribute("categoryBean", categoryBean);
		} else if (action.equals("view")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<SpecificAttribute> specificAttributes = SpecificAttributeDAO.getSpecificAttributes(id);
			Category category = CategoryDAO.findById(id);
			category.setSpecificAttributes(specificAttributes);
			categoryBean = new CategoryBean(category);
			session.setAttribute("categoryBean", categoryBean);
		} else if (action.equals("delete")) {
			String id = request.getParameter("id");
			CategoryDAO.deleteCategory(Integer.parseInt(id));
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

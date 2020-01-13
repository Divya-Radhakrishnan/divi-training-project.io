package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.truyum.Dao.MenuItemDao;

import com.cognizant.truyum.Dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet("/EditMenuItem")
public class EditMenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItem() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		boolean active = request.getParameter("active").equals("Yes");
		// SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfLaunch;
		dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String category = request.getParameter("category");
		boolean freeDelivery = request.getParameter("freeDelivery") != null;
		MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItems(menuItem);
		request.getRequestDispatcher("edit-menu-item-status.jsp").forward(request, response);
	}

}

package ru.storageproduct.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import ru.storageproduct.IDAO.CategoryDAO;
import ru.storageproduct.IDAO.DaoFactory;
import ru.storageproduct.Model.Category;
import ru.storageproduct.MysqlDaoFactory.MySqlCategoryDao;
import ru.storageproduct.MysqlDaoFactory.MySqlDaoFactory;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SELECT_NUMBER = "5" ; /* Default variable is for view of list products on the page */
	private 			 DaoFactory conn;
	private 			 CategoryDAO cat;

	public CategoryController() {

		super();
		conn = new MySqlDaoFactory();

		try {

			cat = conn.getCategoryDao((Connection) conn.getConnection());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	/* Method for adding new category */
	protected void addCat(String catTitle, String catDescription) {

		Category temp = new Category(catTitle, catDescription);
		cat.create(temp);

	}
	
	/* Method for deleting product */
	protected void deleteCat(String titleCat) {

		cat.delete(titleCat);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			/* Deleting category */
			String titleCat = request.getParameter("titleCat");

			if (titleCat != null)
				deleteCat(titleCat);

			/* Adding category */
			String catTitle = request.getParameter("cattitle");
			String catDescription = request.getParameter("catdescription");

			if (catTitle != null && catDescription != null)
				addCat(catTitle, catDescription);

			/* Select controller */
			String numSelCat = request.getParameter("selectCategory");

			List<Category> listCategory = new ArrayList<Category>();
			if (numSelCat == null)
				numSelCat = SELECT_NUMBER;
			
			/* Forming of list with type Category for output */
			
			for (Category c : cat.getNumSelect(numSelCat))
				listCategory.add(c);

			/* Forming of list with type Category for output */
			request.getSession().setAttribute("listCategory", listCategory);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/category.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

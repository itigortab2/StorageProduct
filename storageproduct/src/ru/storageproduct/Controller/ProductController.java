package ru.storageproduct.Controller;

import java.io.IOException;
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

import ru.storageproduct.IDAO.CategoryDAO;
import ru.storageproduct.IDAO.DaoFactory;
import ru.storageproduct.IDAO.ProductDAO;
import ru.storageproduct.Model.Category;
import ru.storageproduct.Model.Product;
import ru.storageproduct.MysqlDaoFactory.MySqlDaoFactory;

import com.mysql.jdbc.Connection;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_NUMBER = "5"; /* Default variable is for view of list products on the page */
	private 			 DaoFactory conn;
	private 			 ProductDAO pr;

	public ProductController() {
		
		super();
		conn = new MySqlDaoFactory();
		
		try {

			pr = conn.getProductDao((Connection) conn.getConnection());

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

	/* Method adding new product */
	protected void addProduct(String prTitle, String prDescription,
			Double price, Integer number, String img, Integer idCat) {

		Product temp = new Product(prTitle, prDescription, price, number, img,
				idCat);
		pr.create(temp);

	}

	/* Method deleting product */
	protected void deleteProduct(String titleProduct) {

		pr.delete(titleProduct);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			/* Output number of articles */
			String numSelCat = request.getParameter("selectPr");

			if (numSelCat == null)
				numSelCat = SELECT_NUMBER;

			/* Delete product */
			String titlePr = request.getParameter("titlePr");

			if (titlePr != null)
				deleteProduct(titlePr);

			/* Adding of product */
			String prTitle = request.getParameter("prtitle");
			String prDescription = request.getParameter("prdescription");
			String prPrice = request.getParameter("prprice");
			String prNumber = request.getParameter("prnumber");
			String prImg = request.getParameter("primg");
			String prIdCat = request.getParameter("pridcat");

			if (prTitle != null && prDescription != null)
				addProduct(prTitle, prDescription, Double.parseDouble(prPrice),
						Integer.parseInt(prNumber), prImg,
						Integer.parseInt(prIdCat));
			List<Product> list = new ArrayList<Product>();

			/* Select controller */
			String selectCat = request.getParameter("selectCat");

			if (selectCat != null) {
				List<Category> temp = new ArrayList<Category>();

				/* Forming of list with type Category for output */

				for (Category c : (List<Category>) request.getSession()
						.getAttribute("listCategory"))
					temp.add(c);

				/* Forming of list with type Product for output by the category */
				for (Category c : temp) {
					if (c.getTitle().equals(selectCat)) {

						for (Product l : pr.read(c.getIdCat()))
							list.add(l);

					}

				}

			} else {

				for (Product l : pr.getNumSelect(numSelCat))
					list.add(l);
			}
			/* Adding of the "productList" in the session */
			request.getSession().setAttribute("productList", list);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/product.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

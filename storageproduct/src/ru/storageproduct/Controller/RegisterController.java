package ru.storageproduct.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.storageproduct.Data.UserIO;
import ru.storageproduct.Model.User;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			ServletContext sc = this.getServletContext();
			String path = sc.getRealPath("/WEB-INF/users.xml");

			if (UserIO.findUser(login, path)) {

				PrintWriter out = response.getWriter();

				response.setContentType("text/html;charset=UTF-8");
				out.println("Уже есть такой юзер!");
				out.println("<a href='index.jsp'>Вернуться</a> ");

			} else {

				User user = new User(login, password, email, 0);
				System.out.println(login);

				UserIO.add(user, path);

				response.sendRedirect("index.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package ru.storageproduct.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import ru.storageproduct.Data.UserIO;
import ru.storageproduct.Model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {

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

			ServletContext sc = this.getServletContext();
			String path = sc.getRealPath("/WEB-INF/users.xml");

			if (!UserIO.authUser(login, password, path)) {

				response.sendRedirect("register.jsp");

			} else {
				User user = new User();

				String lineuser = UserIO.getStringUser(login, path);

				System.out.println(lineuser);

				StringTokenizer st = new StringTokenizer(lineuser, "|");

				user.setLogin(st.nextToken());
				user.setPassword(st.nextToken());
				user.setEmail(st.nextToken());
				user.setPermission(Integer.parseInt(st.nextToken()));

				HttpSession session = request.getSession(true);

				session.setAttribute("user", user);

				RequestDispatcher dispatcher = request.getServletContext()
						.getRequestDispatcher("/CategoryController");
				dispatcher.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

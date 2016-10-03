package ru.storageproduct.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import ru.storageproduct.IDAO.CategoryDAO;
import ru.storageproduct.IDAO.DaoFactory;
import ru.storageproduct.Model.Category;
import ru.storageproduct.MysqlDaoFactory.MySqlCategoryDao;
import ru.storageproduct.MysqlDaoFactory.MySqlDaoFactory;


@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	DaoFactory conn;
	CategoryDAO cat;

    public CategoryController() {
		
        super();
        conn = new MySqlDaoFactory();
    	
		try { 
			
			 cat = conn.getCategoryDao((Connection) conn.getConnection());
			
		}
		catch (SQLException e) 
		{
	       
	        e.printStackTrace();
	    }
       
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
           
             
            // Store info in request attribute, before forward to views
           
            request.setAttribute("categoryList", cat.getAll());
             
         
            // Forward to /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/category.jsp");
            dispatcher.forward(request, response);
	       
			
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

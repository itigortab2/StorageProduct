package ru.storageproduct.MysqlDaoFactory;

import ru.storageproduct.IDAO.*;
import ru.storageproduct.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {

    private String user = "root"; 
    private String password = "12345"; 
    private String url = "jdbc:mysql://localhost:3308/storageproduct"; 
    private String driver = "com.mysql.jdbc.Driver"; 
    
    public Connection getConnection() throws SQLException  {
    	
    	
       
			
        	return DriverManager.getConnection(url, user, password);    	
    }

    @Override
    public CategoryDAO getCategoryDao(Connection connection) {
        
    	return new MySqlCategoryDao(connection);
    }

    @Override
    public ProductDAO getProductDao(Connection connection) {
        
    	return null;
    }

    
    public MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

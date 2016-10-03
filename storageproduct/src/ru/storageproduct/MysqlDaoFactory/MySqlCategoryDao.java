package ru.storageproduct.MysqlDaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.storageproduct.IDAO.CategoryDAO;
import ru.storageproduct.Model.Category;

public class MySqlCategoryDao implements CategoryDAO {
    
	private final Connection connection;

	@Override
    public Category create() {
        return null;
    }

   @Override
    public Category read(int key) throws SQLException 
    {
        
	   	String sql = "SELECT * FROM storageproduct.category WHERE id = ?;";
       
	   	PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        rs.next();
        
        Category g = new Category();
        
        g.setIdCategory(rs.getInt("idCategory"));
        g.setTitle(rs.getString("title"));
        g.setDescription(rs.getString("description"));
        
        return g;
    }

   @Override
    public void update(Category category) {

    }

   @Override
    public void delete(Category category) {

    }

   @Override
    public List<Category> getAll() throws SQLException {
        String sql = "SELECT * FROM storageproduct.category;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Category> list = new ArrayList<Category>();
        while (rs.next()) {
            Category g = new Category();
            g.setIdCategory(rs.getInt("idCategory"));
            g.setTitle(rs.getString("title"));
            g.setDescription(rs.getString("description"));
            list.add(g);
        }
        return list;
    }

   
    public MySqlCategoryDao(Connection connection) {
        this.connection = connection;
    }
}
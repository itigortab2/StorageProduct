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
	public Category read(String key) throws SQLException {

		String sql = "SELECT * FROM storageproduct.category WHERE title = "
				+ key + ";";

		PreparedStatement stm = connection.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();
		rs.next();

		Category g = new Category();
		g.setIdCat(rs.getInt("idCat"));
		g.setTitle(rs.getString("title"));
		g.setDescription(rs.getString("description"));

		return g;
	}

	@Override
	public void create(Category category) {

		String sql = "INSERT INTO storageproduct.category (title,description) VALUES ('"
				+ category.getTitle()
				+ "','"
				+ category.getDescription()
				+ "');";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String title) {

		String sql = "DELETE FROM storageproduct.category WHERE title = '"
				+ title + "';";

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Category> getNumSelect(String selectNumber) throws SQLException {

		String sql;

		if (selectNumber.equals("Все"))
			sql = "SELECT * FROM storageproduct.category;";
		else
			sql = "SELECT * FROM storageproduct.category LIMIT " + selectNumber
					+ ";";

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Category> list = new ArrayList<Category>();

		while (rs.next()) {

			Category g = new Category();
			
			g.setIdCat(rs.getInt("idCat"));
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
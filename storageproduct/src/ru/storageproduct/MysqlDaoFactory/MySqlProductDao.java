package ru.storageproduct.MysqlDaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.storageproduct.IDAO.ProductDAO;
import ru.storageproduct.Model.Category;
import ru.storageproduct.Model.Product;

public class MySqlProductDao implements ProductDAO {

	private final Connection connection;

	public MySqlProductDao(Connection connection) {

		this.connection = connection;

	}

	@Override
	public Product read(int key) {

		String sql = "SELECT * FROM storageproduct.product WHERE id = " + key
				+ ";";

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			rs.next();

			Product p = new Product();

			p.setIdProduct(rs.getInt("idProduct"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getDouble("price"));
			p.setNumber(rs.getInt("number"));
			p.setCat(rs.getInt("cat"));
			p.setImg(rs.getString("img"));

			return p;
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	@Override
	public void create(Product p) {

		String sql = "INSERT INTO storageproduct.product" + "VALUES ("
				+ p.getIdProduct() + "," + p.getTitle() + ","
				+ p.getDescription() + "," + p.getPrice() + "," + p.getNumber()
				+ "," + p.getImg() + "," + p.getCat() + ");";

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void delete(String title) {

		String sql = "DELETE FROM storageproduct.product WHERE title = '"
				+ title + "';";

		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getNumSelect(String selectNumber) throws SQLException {
		String sql;

		if (selectNumber.equals("Все"))
			sql = "SELECT * FROM storageproduct.product;";
		else
			sql = "SELECT * FROM storageproduct.product LIMIT " + selectNumber
					+ ";";

		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();

		List<Product> list = new ArrayList<Product>();

		while (rs.next()) {

			Product p = new Product();

			p.setIdProduct(rs.getInt("idProduct"));
			p.setTitle(rs.getString("title"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getDouble("price"));
			p.setNumber(rs.getInt("number"));
			p.setCat(rs.getInt("cat"));
			p.setImg(rs.getString("img"));

			list.add(p);

		}

		return list;

	}

}

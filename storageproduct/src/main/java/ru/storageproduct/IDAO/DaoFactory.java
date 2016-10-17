package ru.storageproduct.IDAO;

import java.sql.Connection;
import java.sql.SQLException;

import ru.storageproduct.Model.*;

public interface DaoFactory {

	public Connection getConnection() throws SQLException;

	public CategoryDAO getCategoryDao(Connection connection);

	public ProductDAO getProductDao(Connection connection);

}
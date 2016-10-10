package ru.storageproduct.IDAO;

import java.sql.SQLException;
import java.util.List;

import ru.storageproduct.Model.Category;

public interface CategoryDAO {
   
    public Category read(String key) throws SQLException;
   
    public void create(Category cat);
   
    public void delete(String title);

    public List<Category> getNumSelect(String num) throws SQLException;
	  
}

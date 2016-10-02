package ru.storageproduct.IDAO;

import java.sql.SQLException;
import java.util.List;
import ru.storageproduct.Model.Category;

public interface CategoryDAO {

   
    public Category create();

   
    public Category read(int key) throws SQLException;

   
    public void update(Category cat);

   
    public void delete(Category cat);

   
    public List<Category> getAll() throws SQLException;
	
}

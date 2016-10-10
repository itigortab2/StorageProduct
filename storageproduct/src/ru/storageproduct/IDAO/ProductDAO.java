package ru.storageproduct.IDAO;

import java.sql.SQLException;
import java.util.List;

import ru.storageproduct.Model.Product;


public interface ProductDAO {
	

    public Product read(int key);
    
    public void create(Product product);
    
    public void delete(String product);
  
    public List<Product> getNumSelect(String numSelCat) throws SQLException;
	
}

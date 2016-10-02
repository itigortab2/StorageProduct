package ru.storageproduct.IDAO;

import ru.storageproduct.Model.Product;

import java.util.List;


public interface ProductDAO {

	
    public Product create();

    
    public Product read(int key);

    
    public void update(Product product);

    
    public void delete(Product product);

  
    public List<Product> getAll();
	
}

package serviceproducts.java.service;

import java.util.List;

import serviceproducts.java.entity.Product;

public interface IProductoService {
    
    public List<Product> findAll();
    public Product findById(Long Id);
    
    


}

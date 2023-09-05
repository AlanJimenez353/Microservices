package serviceproducts.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import serviceproducts.java.entity.Product;
import serviceproducts.java.entity.dao.ProductDao;

@Service
public class ProductServiceImpl implements IProductoService {

    @Autowired
    private ProductDao productDao;


    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>)productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null); //orElse retornal el objeto producto y si no existe retorna NULL
    }
    
}

package serviceproducts.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import serviceproducts.java.entity.Product;
import serviceproducts.java.service.IProductoService;

@RestController
public class ProductController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/list")
    public List<Product> list() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        return productoService.findById(id);
    }

}

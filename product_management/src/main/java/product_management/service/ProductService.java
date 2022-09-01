package product_management.service;

import product_management.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void remove(Long id);
}

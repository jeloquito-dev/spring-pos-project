package com.playground.springposproject.Service;

import com.playground.springposproject.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void saveProduct(Product product);
}

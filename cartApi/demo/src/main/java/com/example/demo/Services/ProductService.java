package com.example.demo.Services;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    //public void deleteProductById(String id) {

       // productRepository.deleteById(id);
   // }

    public Product getProduct(String id) {
        Product product = getProductById(id);
        return product;
    }

    public Product createProduct(Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }

    //public void deleteProduct(String id) {
       // productRepository.delete(id);
  //  }
}



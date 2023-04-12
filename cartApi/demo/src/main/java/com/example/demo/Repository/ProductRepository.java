package com.example.demo.Repository;



import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String>{
   // Optional<User> deleteProductById(String id);
   // void delete(String id);

}




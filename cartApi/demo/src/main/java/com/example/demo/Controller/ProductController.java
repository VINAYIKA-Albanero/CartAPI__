package com.example.demo.Controller;



        import com.example.demo.Services.ProductService;
        import com.example.demo.model.Product;
//        import com.example.demo.service.ProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

//    @PutMapping("/{id}")
//    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
//        return productService.updateProduct(id, product);
//    }

   //
}

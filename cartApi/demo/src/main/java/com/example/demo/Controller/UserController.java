package com.example.demo.Controller;
import com.example.demo.model.Product;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.demo.Services.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {
    private WebClient webClient = WebClient.create("Http://localhost:9091");
    @Autowired
    private UserService userService;

    @PostMapping()
    public User createUser(@RequestBody User user) {

//        List<Product> productModelList=  webClient
//                .get()
//                .uri("getAllProduct")
//                .retrieve()
//                .bodyToFlux(Product.class).collectList().block();
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        List<Product> productModelList=  webClient
                .get()
                .uri("getAllProduct")
                .retrieve()
                .bodyToFlux(Product.class).collectList().block();

        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}


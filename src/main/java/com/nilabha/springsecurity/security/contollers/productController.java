package com.nilabha.springsecurity.security.contollers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class productController {
    private record Product(String name, Integer price){

    };
    List<Product> products=new ArrayList<>(List.of(new Product("A",99),new Product("B",100)));

    @GetMapping
    private List<Product> getProducts(){
        return products;
    }
    @PostMapping
    private Product savedProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }


}

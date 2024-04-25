package com.example.GraphqlDemo.client;

import com.example.GraphqlDemo.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "productFeignClient", url = "http://127.0.0.1:7770")
public interface ProductFeignClient {
    @GetMapping("/products")
    List<Product> getAllProducts();

    @GetMapping("/product/{productId}")
    Product getProductById(@PathVariable Long productId);

    @PostMapping("/products")
    Product createProduct(Product product);

    @PutMapping("/products/{productId}")
    Product updateProduct(@PathVariable Long productId, Product product);

    @DeleteMapping("/products/{productId}")
    void deleteProduct(@PathVariable Long productId);
}

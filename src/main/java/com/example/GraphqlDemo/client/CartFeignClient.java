package com.example.GraphqlDemo.client;

import com.example.GraphqlDemo.entity.Cart;
import com.example.GraphqlDemo.entity.Product;
import com.example.GraphqlDemo.response.CartResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "cartFeignClient", url = "http://127.0.0.1:7770")
public interface CartFeignClient {
    @PostMapping("/carts")
    CartResponseDto createCart(Cart cart);

    @GetMapping("/carts")
    List<Cart> getAllCarts();
}

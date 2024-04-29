package com.example.GraphqlDemo.controller;

import com.example.GraphqlDemo.dto.CartDto;
import com.example.GraphqlDemo.dto.ProductDto;
import com.example.GraphqlDemo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @QueryMapping
    public List<CartDto> getAllCart() {
        return cartService.getAllCarts();
    }

    @QueryMapping
    public CartDto getCartById(@Argument long cartId) {
        return cartService.getCartById(cartId);
    }

    @MutationMapping
    public CartDto createCart(@Argument(value = "cart") CartDto cartDto) {
        return cartService.addCart(cartDto);
    }

    @MutationMapping
    public List<ProductDto> addProductToCart(@Argument long cartId, @Argument List<ProductDto> products) {
        return cartService.addProductToCart(cartId, products);
    }

    @MutationMapping
    public ProductDto updateProduct(@Argument ProductDto product) {
        return cartService.updateProduct(product);
    }

}

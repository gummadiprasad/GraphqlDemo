package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.dto.CartDto;
import com.example.GraphqlDemo.dto.ProductDto;

import java.util.List;

public interface CartService {

    CartDto addCart(CartDto cartDto);
    List<ProductDto> addProductToCart(long cartId, List<ProductDto> productDtoList);
    List<CartDto> getAllCarts();
    CartDto getCartById(long cartId);
    ProductDto updateProduct(ProductDto productDto);
}

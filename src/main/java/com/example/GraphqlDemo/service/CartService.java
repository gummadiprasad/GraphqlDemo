package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.entity.Cart;
import com.example.GraphqlDemo.response.CartResponseDto;

import java.util.List;

public interface CartService {
    CartResponseDto save(Cart cart) throws Exception;
    List<Cart> getAll() throws Exception;
}

package com.example.GraphqlDemo.controller;

import com.example.GraphqlDemo.entity.Cart;
import com.example.GraphqlDemo.response.CartResponseDto;
import com.example.GraphqlDemo.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    private static Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @MutationMapping
    public CartResponseDto createCart(@Argument Cart cart) {
        LOGGER.info("Entering the create cart method to create cart");
        CartResponseDto responseDto = new CartResponseDto();
        try {
            responseDto =  cartService.save(cart);
            LOGGER.info("Successfully created cart with id {}", responseDto.getId());
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from create cart method");
        return responseDto;
    }

    @QueryMapping
    public List<Cart> getAllCarts() {
        LOGGER.info("Entering the get all carts method");
        List<Cart> carts = null;
        try {
            carts = cartService.getAll();
            LOGGER.info("Successfully fetched all carts");
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from get all carts method");
        return carts;
    }


}

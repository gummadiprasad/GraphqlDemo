package com.example.GraphqlDemo.converter;

import com.example.GraphqlDemo.dto.CartDto;
import com.example.GraphqlDemo.entity.Cart;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class CartConverter implements Converter<CartDto, Cart> {
    @Override
    public @NonNull Cart convert(CartDto source) {
        return new Cart(0L, source.getTitle(), Collections.emptyList());
    }
}

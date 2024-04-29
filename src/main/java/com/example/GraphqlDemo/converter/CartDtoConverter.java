package com.example.GraphqlDemo.converter;

import com.example.GraphqlDemo.dto.CartDto;
import com.example.GraphqlDemo.dto.ProductDto;
import com.example.GraphqlDemo.entity.Cart;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CartDtoConverter implements Converter<Cart, CartDto> {

    private final ProductDtoConverter productDtoConverter;

    @Override
    public @NonNull CartDto convert(Cart source) {
        List<ProductDto> productDtos = source.getProducts().stream().map(productDtoConverter::convert).toList();
        return new CartDto(source.getId(), source.getTitle(), productDtos);
    }
}

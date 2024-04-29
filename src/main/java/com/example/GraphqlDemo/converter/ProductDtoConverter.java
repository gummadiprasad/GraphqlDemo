package com.example.GraphqlDemo.converter;

import com.example.GraphqlDemo.dto.ProductDto;
import com.example.GraphqlDemo.entity.Product;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProductDtoConverter implements Converter<Product, ProductDto> {

    @Override
    public @NonNull ProductDto convert(Product source) {
        return new ProductDto(source.getId(), source.getDescription(), source.getName(), source.getPrice());
    }
}

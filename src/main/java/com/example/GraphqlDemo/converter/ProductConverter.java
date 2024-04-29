package com.example.GraphqlDemo.converter;

import com.example.GraphqlDemo.dto.ProductDto;
import com.example.GraphqlDemo.entity.Product;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter implements Converter<ProductDto, Product> {

    @Override
    public @NonNull Product convert(ProductDto source) {

        Product product = new Product();
        product.setId(source.getId());
        product.setDescription(source.getDescription());
        product.setName(source.getName());
        product.setPrice(source.getPrice());

        return product;
    }
}

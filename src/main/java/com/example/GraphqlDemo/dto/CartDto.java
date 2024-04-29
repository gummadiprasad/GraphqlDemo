package com.example.GraphqlDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String title;

    private List<ProductDto> products = new ArrayList<>();
}

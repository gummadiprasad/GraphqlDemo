package com.example.GraphqlDemo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String title;

    @Valid
    private List<ProductDto> products = new ArrayList<>();
}

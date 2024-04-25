package com.example.GraphqlDemo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartResponseDto {
    private Long id;
    private String cartName;
    private int quantity;
}

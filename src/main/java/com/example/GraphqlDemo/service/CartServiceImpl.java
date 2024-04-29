package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.converter.CartConverter;
import com.example.GraphqlDemo.converter.CartDtoConverter;
import com.example.GraphqlDemo.converter.ProductConverter;
import com.example.GraphqlDemo.converter.ProductDtoConverter;
import com.example.GraphqlDemo.dto.CartDto;
import com.example.GraphqlDemo.dto.ProductDto;
import com.example.GraphqlDemo.entity.Cart;
import com.example.GraphqlDemo.entity.Product;
import com.example.GraphqlDemo.exception.ResourceNotFoundException;
import com.example.GraphqlDemo.repository.CartRepository;
import com.example.GraphqlDemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private static Logger LOGGER= LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartDtoConverter cartDtoConverter;
    private final CartConverter cartConverter;
    private final ProductDtoConverter productDtoConverter;
    private final ProductConverter productConverter;

    @Override
    public CartDto addCart(CartDto cartDto) {
        LOGGER.info("Entered the add cart method in cart service");
        Cart cart = cartConverter.convert(cartDto);
        Cart savedTodo = cartRepository.save(cart);

        List<ProductDto> productDtoList = cartDto.getProducts().stream()
                .map(productConverter::convert)
                .map(product -> {
                    LOGGER.info("Entered the save product while adding cart");
                    product.setCart(savedTodo);
                    return productDtoConverter.convert(productRepository.save(product));
                }).toList();

        cartDto = cartDtoConverter.convert(savedTodo);
        cartDto.setProducts(productDtoList);
        return cartDto;
    }

    @Override
    public List<ProductDto> addProductToCart(long todoId, List<ProductDto> productDtoList) {
        LOGGER.info("Entered the add product to cart method in cart service");
        Cart cart = cartRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Cart with id '" + todoId + "'  not found"));

        return productDtoList.stream().map(todoItemDto -> {
            Product product = productConverter.convert(todoItemDto);
            product.setCart(cart);
            product = productRepository.save(product);
            return productDtoConverter.convert(product);
        }).toList();
    }

    @Override
    public List<CartDto> getAllCarts() {
        LOGGER.info("Entered the getAll carts method in cart service");
        return cartRepository.findAll().stream().map(cartDtoConverter::convert).toList();
    }

    @Override
    public CartDto getCartById(long cartId) {
        LOGGER.info("Entered the get cart by id method in cart service");
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart with id '" + cartId + "'  not found"));
        return cartDtoConverter.convert(cart);
    }

    @Override
    public ProductDto updateProduct(ProductDto todoItemDto) {
        LOGGER.info("Entered the update product method in cart service");
        if (!productRepository.existsById(todoItemDto.getId())) {
            throw new ResourceNotFoundException("Cart item with id '" + todoItemDto.getId() + "'  not found");
        }
        productRepository.save(productConverter.convert(todoItemDto));
        return todoItemDto;
    }

}

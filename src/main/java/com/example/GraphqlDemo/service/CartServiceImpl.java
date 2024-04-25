package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.client.CartFeignClient;
import com.example.GraphqlDemo.config.MockUtil;
import com.example.GraphqlDemo.entity.Cart;
import com.example.GraphqlDemo.repository.CartRepository;
import com.example.GraphqlDemo.response.CartResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private static Logger LOGGER= LoggerFactory.getLogger(CartServiceImpl.class);

    @Autowired
    CartRepository cartRepository;

    private final CartFeignClient cartFeignClient;

    @Value("${api.mock.feignEndPoint.cartService}")
    private boolean cartService;

    @SchemaMapping
    @Override
    public CartResponseDto save(Cart cart) throws Exception {
        LOGGER.info("Entered the save cart method in cart service"+cartService);
        try {
            if (cartService) {
                LOGGER.info("Calling mock data for cart creation");
                return MockUtil.getMock("cartMockResponse", CartResponseDto.class);
            }
            return cartFeignClient.createCart(cart);
        } catch (Exception e) {
            throw new Exception("No carts found");
        }
    }

    @SchemaMapping
    @Override
    public List<Cart> getAll() throws Exception {
        LOGGER.info("Entered the getAll carts method in cart service");
        try {
            if (cartService) {
                LOGGER.info("Calling mock data for get cart details");
                return List.of(MockUtil.getMock("cartMockResponse", Cart.class));
            }
            return cartFeignClient.getAllCarts();
        } catch (Exception e) {
            throw new Exception("No carts found");
        }
    }
}

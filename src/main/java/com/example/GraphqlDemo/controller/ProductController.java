package com.example.GraphqlDemo.controller;

import com.example.GraphqlDemo.entity.Product;
import com.example.GraphqlDemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @MutationMapping
    public Product createProduct(@Argument Product product) {
        LOGGER.info("Entering the create product method to create product");

        try {
            product = productService.save(product);
            LOGGER.info("Successfully created product with id {}", product.getId());

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from create product method");
        return product;
    }

    @QueryMapping
    public List<Product> getAllProducts() {
        LOGGER.info("Entering the get all products method");
        List<Product> products = null;
        try {
            products = productService.getAll();
            LOGGER.info("Successfully fetched all products");
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from get all products method");
        return products;
    }

    @MutationMapping
    Boolean updateProduct(@Argument Product product) {
        LOGGER.info("Entering the update product method to update user");
        Boolean response = Boolean.FALSE;
        try {
            response = productService.update(product);
            LOGGER.info("Successfully updated product with id {}", product.getId());
            response = Boolean.TRUE;
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from update product method");
        return response;
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long productId) {
        LOGGER.info("Entering the delete product method with id : {}", productId);
        Boolean response = null;
        try {
            response = productService.delete(productId);
            LOGGER.info("Successfully deleted the product with id {}", productId);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from delete user method");
        return response;
    }

    @QueryMapping
    public Product getProduct(@Argument Long productId) {
        LOGGER.info("Entering the get product method with id : {}", productId);
        Product product = null;
        try {
            product = productService.get(productId);
            LOGGER.info("Successfully fetched the product with id {}", product.getId());
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from get product method");
        return product;
    }
}

//package com.example.GraphqlDemo.service;
//
//import com.example.GraphqlDemo.entity.Product;
//import com.example.GraphqlDemo.repository.ProductRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.SchemaMapping;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class ProductServiceImpl implements ProductService{
//
//    private static Logger LOGGER= LoggerFactory.getLogger(ProductServiceImpl.class);
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @SchemaMapping
//    @Override
//    public Product save(Product product) throws Exception {
//        LOGGER.info("Entered the save product method in product service");
//        product = productRepository.save(product);
//        if (product == null) {
//            LOGGER.error("Error in creating the product");
//            throw new Exception("Error in creating the product");
//        }
//        LOGGER.info("Exiting the save product method in product service");
//        return  product;
//    }
//
//    @SchemaMapping
//    @Override
//    public List<Product> getAll() throws Exception {
//        LOGGER.info("Entered the getAll products method in product service");
//        List<Product> products = productRepository.findAll();
//        if (products.size()==0) {
//            LOGGER.error("No products found");
//            throw new Exception("No products found");
//        }
//        LOGGER.info("Exiting the getAll products method in product service");
//        return products;
//    }
//
//    @SchemaMapping
//    @Override
//    public Boolean update(Product product) throws Exception {
//        LOGGER.info("Entered the update product method in product service");
//        Optional<Product> userOptional = productRepository.findById(product.getId());
//        Boolean response = Boolean.FALSE;
//        if (!userOptional.isEmpty()) {
//            productRepository.save(product);
//            response = Boolean.TRUE;
//        }else{
//            LOGGER.error("Error in updating the product");
//            throw new Exception("Error in updating the product");
//        }
//        LOGGER.info("Exiting the update product method in product service");
//        return response;
//    }
//
//    @SchemaMapping
//    @Override
//    public Boolean delete(Long productId) throws Exception {
//        LOGGER.info("Entered the delete product method in product service");
//        Optional<Product> productOptional = productRepository.findById(productId);
//
//        Boolean response = Boolean.FALSE;
//        if (!productOptional.isEmpty()) {
//            productRepository.delete(productOptional.get());
//            response = Boolean.TRUE;
//        }else{
//            LOGGER.error("Error in deleting the product");
//            throw new Exception("Error in deleting the product");
//        }
//        LOGGER.info("Exiting the delete product method in product service");
//        return response;
//    }
//
//    @SchemaMapping
//    @Override
//    public Product get(Long productId) throws Exception {
//        LOGGER.info("Entered the get product method in product service");
//        Optional<Product> userOptional = productRepository.findById(productId);
//        if (userOptional.isEmpty()) {
//            LOGGER.error("No product found with the ID {}" , productId);
//            throw new Exception("No product found with the ID " + productId);
//        }
//        LOGGER.info("Exiting the get product method in product service");
//        return userOptional.get();
//    }
//}

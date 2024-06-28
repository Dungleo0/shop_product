package com.example.shopapp.product;


import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(String id) {
        return productRepository.findById(id).get();
    }
}

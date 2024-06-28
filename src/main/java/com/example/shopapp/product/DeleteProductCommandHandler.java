package com.example.shopapp.product;

import com.example.shopapp.Command;
import com.example.shopapp.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class DeleteProductCommandHandler implements Command<String, Void> {

    private final ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(DeleteProductCommandHandler.class);

    public DeleteProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(String id) {
//        productRepository.deleteById(id);

        logger.error("Delete Product Command Handler, id: " + id + " " + getClass().getSimpleName());
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {

            throw new ProductNotFoundException();
        }
        productRepository.delete(optionalProduct.get());
        return ResponseEntity.ok().build();
    }
}

package com.example.shopapp.product;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    private final ProductService productService;

    private final DeleteProductCommandHandler deleteProductCommandHandler;

    public ProductController(ProductRepository productRepository, ProductService productService, DeleteProductCommandHandler deleteProductCommandHandler) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.deleteProductCommandHandler = deleteProductCommandHandler;
    }


    @GetMapping("{id}")
    public Product testProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }


    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) {
        return deleteProductCommandHandler.execute(id);
    }

}

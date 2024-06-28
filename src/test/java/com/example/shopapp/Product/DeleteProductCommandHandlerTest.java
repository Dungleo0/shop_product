package com.example.shopapp.Product;


import com.example.shopapp.DemoApplicationTests;
import com.example.shopapp.exception.ProductNotFoundException;
import com.example.shopapp.product.DeleteProductCommandHandler;
import com.example.shopapp.product.Product;
import com.example.shopapp.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = DemoApplicationTests.class)
public class DeleteProductCommandHandlerTest {

    @Mock
    private ProductRepository productRepository;

    private DeleteProductCommandHandler deleteProductCommandHandler;

    @BeforeEach
    void setup() {
        deleteProductCommandHandler = new DeleteProductCommandHandler(productRepository);
    }

    @Test
    void deleteProductCommandHandler_returnsSuccess() {
        String id = "1";
        Product product = new Product();
        product.setId(id);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = deleteProductCommandHandler.execute(id);
        verify(productRepository).delete(product);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }


    @Test
    void deleteProductCommandHandler_throwsProductNotFoundException() {
        String id = "1";
        Product product = new Product();
        product.setId(id);

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, ()
                -> deleteProductCommandHandler.execute(id));

        assertEquals("Product not found", exception.getSimpleResponse().getMessage());
    }


}

package com.example.shopapp.Category;


import com.example.shopapp.DemoApplicationTests;
import com.example.shopapp.category.Category;
import com.example.shopapp.category.CategoryRepository;
import com.example.shopapp.category.GetCategoryQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = DemoApplicationTests.class)
public class GetCategoryQueryHandlerTest {

    @Mock
    private CategoryRepository categoryRepository;

    private GetCategoryQueryHandler getCategoryQueryHandler;

    @BeforeEach
    void setup() {
        getCategoryQueryHandler = new GetCategoryQueryHandler(categoryRepository);
    }

    @Test
    void categoryQueryHandler_returnsList() {
        List<Category> categoryList = Arrays.asList(
                new Category("Electric"),
                new Category("Bathroom"),
                new Category("Automotive")
        );

        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<String> expected = Arrays.asList("Electric", "Bathroom", "Automotive");

        ResponseEntity<List<String>> actual = getCategoryQueryHandler.execute(null);
        assertEquals(ResponseEntity.ok(expected), actual);

    }


    @Test
    void setGetCategoryQueryHandler_returnsEmptyList() {
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<String>> actual = getCategoryQueryHandler.execute(null);
        assertEquals(ResponseEntity.ok(Collections.emptyList()), actual);
    }
}

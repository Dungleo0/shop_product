package com.example.shopapp.category;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final GetCategoryQueryHandler getCategoryHandler;

    public CategoryController(GetCategoryQueryHandler getCategoryHandler) {
        this.getCategoryHandler = getCategoryHandler;
    }

    @GetMapping()
    public ResponseEntity<List<String>> createCategory() {
        return getCategoryHandler.execute(null);
    }
}

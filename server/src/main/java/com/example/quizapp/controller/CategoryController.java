package com.example.quizapp.controller;

import com.example.quizapp.Category;
import com.example.quizapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        String categoryName = category.getName();
        if (categoryName != null && !categoryName.isEmpty()) {
            return categoryService.addCategory(category);
        }

        HashMap errorObj = new HashMap();
        errorObj.put("error", "Name is mandatory to create category");
        return ResponseEntity.badRequest().body(errorObj);
    }
}

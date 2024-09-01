package com.example.quizapp.service;

import com.example.quizapp.Category;
import com.example.quizapp.dao.CategoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoriesDao categoriesDao;

    public ResponseEntity<List<Category>> getCategories() {
        try {
            return new ResponseEntity<>(categoriesDao.findAll(), HttpStatus.OK);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Category> addCategory(Category category) {
        categoriesDao.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}

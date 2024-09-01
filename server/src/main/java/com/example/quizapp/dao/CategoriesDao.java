package com.example.quizapp.dao;

import com.example.quizapp.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDao extends JpaRepository<Category,Integer> {
}

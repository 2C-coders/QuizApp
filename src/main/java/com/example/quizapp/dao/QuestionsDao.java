package com.example.quizapp.dao;

import com.example.quizapp.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    List<Questions> findByDifficultyLevel(String difficultyLevel);
}

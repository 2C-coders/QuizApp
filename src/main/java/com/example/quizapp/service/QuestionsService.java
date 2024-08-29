package com.example.quizapp.service;

import com.example.quizapp.Questions;
import com.example.quizapp.dao.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionsDao questionsDao;

    public List<Questions> getAllQuestions() {
        return questionsDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return questionsDao.findByCategory(category);
    }

    public String addQuestion(Questions questions) {
            questionsDao.save(questions);
            return"success";
    }
}

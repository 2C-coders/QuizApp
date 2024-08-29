package com.example.quizapp.controller;

import com.example.quizapp.Questions;
import com.example.quizapp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @GetMapping("allQuestions")
    public List<Questions> getAllQuestions(){
        List<Questions> questions = questionsService.getAllQuestions();
        System.out.println(questions);
        return questions;
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        return questionsService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Questions questions){
        return questionsService.addQuestion(questions);
    }

}

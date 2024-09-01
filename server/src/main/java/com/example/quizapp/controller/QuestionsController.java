package com.example.quizapp.controller;

import com.example.quizapp.Questions;
import com.example.quizapp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @RequestMapping("allQuestions")
    public ResponseEntity<List<Questions>> getQuestionsByDifficultyLevel(@RequestParam(required = false, name = "difficulty") String difficultyLevel) {
        if (difficultyLevel != null) {
            return questionsService.getQuestionsByDifficultyLevel(difficultyLevel);
        }

        return questionsService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        return questionsService.getQuestionsByCategory(category);
    }

//    @GetMapping("difficulty/{difficultyLevel}")
//    public ResponseEntity<List<Questions>> getQuestionsByDifficultyLevel(@PathVariable String difficultyLevel){
//         return questionsService.getQuestionsByDifficultyLevel(difficultyLevel);
//    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return new ResponseEntity<>(questionsService.addQuestion(questions).getStatusCode());
    }

}

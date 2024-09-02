package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.TestApiService;

@Controller
public class TestApiController {

    private final TestApiService testApiService;

    public TestApiController(TestApiService testApiService) {
        this.testApiService = testApiService;
    }

    @GetMapping("/get-relevant-category")
    public String getRelevantCategory(@RequestParam String question, Model model) {
        // TestApiServiceを呼び出して、最も関連するカテゴリを取得
        String mostRelevantCategory = testApiService.getMostRelevantCategory(question);
        model.addAttribute("mostRelevantCategory", mostRelevantCategory);
        return "test";
    }
}

package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Category;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.CategoryDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.CategoryResponse;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @RequestMapping("/findAll")
    public ResponseEntity<List<CategoryResponse>> findAll() {

        List<CategoryResponse> categories = categoryService.findCategories();

        return ResponseEntity.ok(categories);
    }
    
    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Category> findCategories(@RequestBody CategoryDTO categoryDTO){

        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }
}

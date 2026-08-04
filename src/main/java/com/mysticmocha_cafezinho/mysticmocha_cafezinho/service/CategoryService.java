package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Category;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.CategoryDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.CategoryResponse;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DepartmentService departmentService;

    public List<CategoryResponse> findCategories() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getDepartment().getId(),
                        category.getDepartment().getName()))
                .toList();
    }

    public Category createCategory(CategoryDTO categoryDTO) {

        Category category = new Category();

        category.setName(categoryDTO.name());
        category.setDepartment(departmentService.findDepartment(categoryDTO.departmentId()));

        return categoryRepository.save(category);
    }
}

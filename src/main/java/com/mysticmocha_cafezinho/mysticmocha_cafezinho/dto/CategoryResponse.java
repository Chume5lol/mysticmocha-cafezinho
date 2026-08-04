package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

public record CategoryResponse(
    Long idCategory,
    String categoryName,
    Long departmentId,
    String departmentName
){}

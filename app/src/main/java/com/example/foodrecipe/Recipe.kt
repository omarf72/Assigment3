package com.example.foodrecipe

data class Recipe(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)
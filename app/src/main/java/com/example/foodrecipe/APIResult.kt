package com.example.foodrecipe

data class APIResult(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)
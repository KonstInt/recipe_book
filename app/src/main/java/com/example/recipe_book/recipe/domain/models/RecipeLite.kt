package com.example.recipe_book.recipe.domain.models

data class RecipeLite(
    val id: String,
    val title: String,
    val photos: List<String>,
    val userId: String,
    val likes: Int,
)
package com.example.recipe_book.recipe.domain.models


data class Recipe(
    val id: String,
    val title: String,
    val photos: List<String>,
    val userId: String,
    val ingredients: List<Ingredient>,
    val steps: List<String>,
    val likes: Int,
    val comments: List<Comments>
)

data class Ingredient(
    val name: String,
    val portion: Double,
    val portionName: String,
)

data class Comments(
    val text: String,
    val userId: String,
    val dateTime: String,
)
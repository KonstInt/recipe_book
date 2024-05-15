package com.example.recipe_book.recipe.domain.models


data class Recipe(
    var id: String? = null,
    val title: String? = null,
    val photos: List<String>? = null,
    val userId: String? = null,
    val ingredients: List<Ingredient>? = null,
    val steps: List<String>? = null,
    val likes: Int? = null,
    val comments: List<Comments>? = null
)

data class Ingredient(
    val name: String? = null,
    val portion: Double? = null,
    val portionName: String? = null,
)

data class Comments(
    val text: String? = null,
    val userId: String? = null,
    val dateTime: String? = null,
)
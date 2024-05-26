package com.example.recipe_book.profile.domain.models

data class Profile(
    val id: String? = null,
    val image: String? = null,
    val name: String? = null,
    val nickname: String? = null,
    val recipes: List<String>? = null,
    val email: String? = null,
);

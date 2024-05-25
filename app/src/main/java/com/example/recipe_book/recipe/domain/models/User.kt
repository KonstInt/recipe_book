package com.example.recipe_book.recipe.domain.models

import com.google.gson.annotations.SerializedName
import com.example.recipe_book.recipe.domain.models.Recipe

data class User(
    @SerializedName("id")
    val id: String? = null,
    val name: String? = null,
    val ava: String? = null,
)
package com.example.recipe_book.recipe.presentation.recipes_list_screen

import com.example.recipe_book.recipe.domain.models.Recipe

data class RecipeListViewState(
    val isLoading: Boolean = false,
    val recipeList: List<Recipe> = emptyList(),
    val error: String? = null
)
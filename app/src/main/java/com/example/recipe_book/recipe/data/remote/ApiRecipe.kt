package com.example.recipe_book.recipe.data.remote

import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite

interface ApiRecipe {

    suspend fun getRecipesList(): List<RecipeLite>
    suspend fun getRecipe(id: String): Recipe
    suspend fun addRecipe(recipe: Recipe)
}
package com.example.recipe_book.recipe.data.remote

import com.example.recipe_book.recipe.domain.models.Recipe

interface ApiRecipe {

    suspend fun getRecipesList():List<Recipe>
    suspend fun getRecipe(id: String):Recipe

}
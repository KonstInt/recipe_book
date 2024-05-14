package com.example.recipe_book.recipe.domain.repository

import arrow.core.Either
import com.example.recipe_book.recipe.domain.models.NetworkError
import com.example.recipe_book.recipe.domain.models.Recipe

interface RecipeRepository {
    suspend fun getRecipesList():Either<NetworkError,List<Recipe>>;
    suspend fun getRecipe(recipeId: String):Either<NetworkError, Recipe>;
}
package com.example.recipe_book.recipe.domain.repository

import arrow.core.Either
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.example.recipe_book.recipe.domain.models.RecipeNetworkError


interface RecipeRepository {
    suspend fun getRecipesList(): Either<RecipeNetworkError, List<RecipeLite>>
    suspend fun getRecipe(recipeId: String): Either<RecipeNetworkError, Recipe>
}
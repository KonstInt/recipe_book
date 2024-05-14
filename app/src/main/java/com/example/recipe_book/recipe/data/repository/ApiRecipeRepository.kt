package com.example.recipe_book.recipe.data.repository

import arrow.core.Either
import com.example.recipe_book.recipe.data.mapper.toNetworkError
import com.example.recipe_book.recipe.data.remote.ApiRecipe
import com.example.recipe_book.recipe.domain.models.NetworkError
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.repository.RecipeRepository

class ApiRecipeRepository constructor(private val apiRecipe: ApiRecipe): RecipeRepository {
    override suspend fun getRecipesList(): Either<NetworkError, List<Recipe>> {
       return Either.catch {
           apiRecipe.getRecipesList();
       }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getRecipe(recipeId: String): Either<NetworkError, Recipe> {
        TODO("Not yet implemented")
    }

}
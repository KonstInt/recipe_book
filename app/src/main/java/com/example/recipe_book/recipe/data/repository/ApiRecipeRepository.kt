package com.example.recipe_book.recipe.data.repository

import arrow.core.Either
import com.example.recipe_book.recipe.data.mapper.toNetworkError
import com.example.recipe_book.recipe.data.remote.ApiRecipe
import com.example.recipe_book.recipe.domain.models.RecipeNetworkError
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.example.recipe_book.recipe.domain.repository.RecipeRepository
import javax.inject.Inject

class ApiRecipeRepository @Inject constructor(private val apiRecipe: ApiRecipe) : RecipeRepository {
    override suspend fun getRecipesList(): Either<RecipeNetworkError, List<RecipeLite>> {
        return Either.catch {
            apiRecipe.getRecipesList()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getRecipe(recipeId: String): Either<RecipeNetworkError, Recipe> {
        TODO("Not yet implemented")
        TODO()
    }

}
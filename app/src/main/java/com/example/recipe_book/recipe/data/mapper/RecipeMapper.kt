package com.example.recipe_book.recipe.data.mapper

import com.example.recipe_book.recipe.domain.models.ApiError
import com.example.recipe_book.recipe.domain.models.RecipeNetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): RecipeNetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return RecipeNetworkError(
        error = error,
        t = this
    )
}
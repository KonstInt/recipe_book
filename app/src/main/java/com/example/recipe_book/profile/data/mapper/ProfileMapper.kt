package com.example.recipe_book.profile.data.mapper

import com.example.recipe_book.profile.domain.models.ApiError
import com.example.recipe_book.profile.domain.models.ProfileNetworkError
import com.example.recipe_book.recipe.domain.models.RecipeNetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): ProfileNetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return ProfileNetworkError(
        error = error,
        t = this
    )
}
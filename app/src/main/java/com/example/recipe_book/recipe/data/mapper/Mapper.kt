package com.example.recipe_book.recipe.data.mapper

import com.example.recipe_book.recipe.domain.models.ApiError
import com.example.recipe_book.recipe.domain.models.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError (
        error = error,
        t=this
    )
}
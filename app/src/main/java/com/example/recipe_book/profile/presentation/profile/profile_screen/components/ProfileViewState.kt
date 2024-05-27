package com.example.recipe_book.profile.presentation.profile.profile_screen.components

import arrow.core.Either
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.example.recipe_book.recipe.domain.models.RecipeNetworkError

data class ProfileViewState(
    val isLoading: Boolean = false,
    val isSingIn: Boolean = false,
    val profile: Profile? = null,
    val userRecipes: List<RecipeLite>? = null,
    val error: String? = null
)
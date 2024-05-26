package com.example.recipe_book.profile.presentation.profile_screen

import com.example.recipe_book.profile.domain.models.Profile

data class ProfileViewState(
    val isLoading: Boolean = false,
    val isSingIn: Boolean = false,
    val profile: Profile? = null,
    val error: String? = null
)
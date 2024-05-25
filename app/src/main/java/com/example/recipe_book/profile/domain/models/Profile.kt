package com.example.recipe_book.profile.domain.models

import javax.annotation.meta.TypeQualifierNickname

data class Profile(
    val id: String,
    val image: String?,
    val name: String,
    val nickname: String,
    val recipes: List<String>?,
    val email: String,
);

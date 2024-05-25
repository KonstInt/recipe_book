package com.example.recipe_book.profile.data.remote

import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite


interface ApiProfile {
    suspend fun getProfileLite(id: String): ProfileLite
    suspend fun getProfile(id: String): Profile
}
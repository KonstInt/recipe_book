package com.example.recipe_book.profile.domain.repository

import arrow.core.Either
import com.example.recipe_book.profile.domain.models.ProfileNetworkError
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite

interface ProfileRepository {
    suspend fun getProfile(id: String):
            Either<ProfileNetworkError, Profile>
    suspend fun getProfileLiteInfo(id: String):
            Either<ProfileNetworkError, ProfileLite>
}
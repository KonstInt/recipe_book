package com.example.recipe_book.profile.domain.repository

import arrow.core.Either
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite
import com.example.recipe_book.profile.domain.models.ProfileNetworkError

interface ProfileRepository {
    suspend fun getProfile(id: String):
            Either<ProfileNetworkError, Profile>

    suspend fun getProfileLiteInfo(id: String):
            Either<ProfileNetworkError, ProfileLite>

    suspend fun signUp(id: String):
            Either<ProfileNetworkError, Profile>

    suspend fun signIn(login: String, password: String):
            Either<ProfileNetworkError, Profile>
}
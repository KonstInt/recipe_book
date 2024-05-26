package com.example.recipe_book.profile.data.repository

import arrow.core.Either
import com.example.recipe_book.profile.data.mapper.toNetworkError
import com.example.recipe_book.profile.data.remote.ApiProfile
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite
import com.example.recipe_book.profile.domain.models.ProfileNetworkError
import com.example.recipe_book.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ApiProfileRepository @Inject constructor(private val apiProfile: ApiProfile) :
    ProfileRepository {

    override suspend fun getProfile(id: String): Either<ProfileNetworkError, Profile> {
        return Either.catch {
            apiProfile.getProfile(id)
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getProfileLiteInfo(id: String): Either<ProfileNetworkError, ProfileLite> {
        return Either.catch {
            apiProfile.getProfileLite(id)
        }.mapLeft { it.toNetworkError() }
    }


}
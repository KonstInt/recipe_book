package com.example.recipe_book.profile.data.remote

import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite

class ApiProfileImpl : ApiProfile {
    override suspend fun getProfileLite(id: String): ProfileLite {
        TODO("Not yet implemented")
    }

    override suspend fun getProfile(id: String): Profile {
        TODO("Not yet implemented")
    }
}
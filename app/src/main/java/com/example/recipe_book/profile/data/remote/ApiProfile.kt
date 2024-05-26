package com.example.recipe_book.profile.data.remote

import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite
import com.google.firebase.auth.FirebaseUser


interface ApiProfile {
    suspend fun getProfileLite(id: String): ProfileLite
    suspend fun getProfile(id: String): Profile

    suspend fun signUpWithEmailPassword(email:String , password:String) : FirebaseUser?

    suspend fun signInWithEmailPassword(email: String , password: String):FirebaseUser?

    fun signOut() : FirebaseUser?

}
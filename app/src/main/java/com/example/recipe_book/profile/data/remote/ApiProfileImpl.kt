package com.example.recipe_book.profile.data.remote

import android.content.ContentValues
import android.util.Log
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite
import com.example.recipe_book.recipe.data.remote.ApiRecipeImpl
import com.example.recipe_book.recipe.domain.models.Recipe
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class ApiProfileImpl : ApiProfile {

    private val auth = FirebaseAuth.getInstance()
    private val _db = FirebaseFirestore.getInstance()

    companion object{
        private const val FIRESTORE_PROFILE = "Profiles"
    }

    override suspend fun getProfileLite(id: String): ProfileLite {
        val profile = getProfile(id)
        return ProfileLite(
            profile.id,
            profile.image,
            profile.name)
    }

    override suspend fun getProfile(id: String): Profile {
        var profile = Profile()
        val docRef = _db.collection(FIRESTORE_PROFILE).document(id)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    profile = document.toObject<Profile>()!!
                } else {
                    Log.d(ContentValues.TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "get failed with ", exception)
            }
        return profile
    }

    override suspend fun signUpWithEmailPassword(email: String, password: String): FirebaseUser? {
        Firebase.auth.createUserWithEmailAndPassword(email,password).await()
        return Firebase.auth.currentUser
    }

    override suspend fun signInWithEmailPassword(email: String, password: String): FirebaseUser? {
        Firebase.auth.signInWithEmailAndPassword(email , password).await()
        return Firebase.auth.currentUser
    }

    override fun signOut(): FirebaseUser? {
        Firebase.auth.signOut()
        return Firebase.auth.currentUser
    }


}
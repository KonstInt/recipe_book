package com.example.recipe_book.profile.data.remote

import android.content.ContentValues
import android.util.Log
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.profile.domain.models.ProfileLite
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
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
                    Log.d(ContentValues.TAG, "No such user")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "get failed with ", exception)
            }
        return profile
    }

    override suspend fun getSignIn(email: String, password: String): Profile? {
        Firebase.auth.signInWithEmailAndPassword(email , password).await()
        return Firebase.auth.currentUser?.let { getProfile(it.uid) }
    }

    override suspend fun getSignUp(profile: Profile, password: String): Profile {
        Firebase.auth.createUserWithEmailAndPassword(profile.email!!, password).await()
        val id = Firebase.auth.currentUser?.uid

        if (id != null) {
            _db.collection(FIRESTORE_PROFILE).document(id).set(profile)
        }
        return profile
    }


}
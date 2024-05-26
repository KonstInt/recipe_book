package com.example.recipe_book.recipe.data.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class ApiRecipeImpl : ApiRecipe {
    companion object{
        private const val FIRESTORE_RECIPE = "Recipes"
    }

    private fun transformToRecipeLite(recipes: List<Recipe>): List<RecipeLite>{
        return recipes.mapNotNull { recipe ->
            val id = recipe.id
            val title = recipe.title
            val photos = recipe.photos
            val userId = recipe.userId
            val likes = recipe.likes

            if (id != null && title != null && photos != null && userId != null && likes != null) {
                RecipeLite(
                    id = id,
                    title = title,
                    photos = photos,
                    userId = userId,
                    likes = likes
                )
            } else {
                null
            }
        }
    }

    private val _db = FirebaseFirestore.getInstance()
    override suspend fun getRecipesList(): List<RecipeLite> {
        var recipeList: List<Recipe> = arrayListOf()
        _db.collection(FIRESTORE_RECIPE)
            .get()
            .addOnSuccessListener { querySnapshot ->
                recipeList = querySnapshot.toObjects(Recipe::class.java)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting document", exception)
            }

        return transformToRecipeLite(recipeList)
    }

    override suspend fun getRecipe(id: String): Recipe {
        var recipe = Recipe()
        val docRef = _db.collection(FIRESTORE_RECIPE).document(id)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    recipe = document.toObject<Recipe>()!!
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
        return recipe
    }

    override suspend fun addRecipe(recipe: Recipe) {

        _db.collection(FIRESTORE_RECIPE).add(recipe)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e) }

    }
}
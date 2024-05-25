package com.example.recipe_book.recipe.data.remote

import android.util.Log
import com.example.recipe_book.recipe.domain.models.Recipe
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

object Statics{
    @JvmStatic val FIREBASE_RECIPE = "recipe"
    @JvmStatic val FIREBASE_INGREDIENT = "ingredient"
    @JvmStatic val FIREBASE_COMMENTS = "comments"
}

class Service: ApiRecipe{
    private val _db = FirebaseDatabase.getInstance().reference
    private val auth = FirebaseAuth.getInstance()

    override suspend fun addRecipe(recipe: Recipe){
        val newRecipe = _db.child(Statics.FIREBASE_RECIPE).push()
        recipe.id = newRecipe.key
        recipe.userId = auth.currentUser?.uid
        newRecipe.setValue(recipe)
    }

    override suspend fun getRecipesList(): List<Recipe> {
        TODO("Not yet implemented")
    }

    // NOTE: Метод надо вызвать один раз и он устанаваливает постоянное "прослушивание" данных
    // то есть onDataChange срабатывает всегда когда в списке рецептов что-то меняется
    // В примере где я смотрела этот код прям в fun onCreate в MainActivity.kt
    override suspend fun getRecipeList() {
        var recipeListener: ValueEventListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val recipes = snapshot.getValue<Recipe>()
                //и вызывать функцию для изменения экрана
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Service", "loadItem:onCancelled", error.toException())
            }
        }
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }


}
package com.example.recipe_book.recipe.data.remote

import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.domain.models.RecipeLite

class ApiRecipeImpl : ApiRecipe {
    override suspend fun getRecipesList(): List<RecipeLite> {
        val photos =
            listOf<String>("https://images.unsplash.com/photo-1554080353-a576cf803bda?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cGhvdG98ZW58MHx8MHx8fDA%3D")
        val r1 = RecipeLite(
            id = "4",
            title = "title1",
            photos = photos,
            userId = "32",
            likes = 20,
        )

        val r2 = RecipeLite(
            id = "4",
            title = "title2",
            photos = photos,
            userId = "32",
            likes = 20,
        )

        return listOf<RecipeLite>(r1, r2)
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }
}
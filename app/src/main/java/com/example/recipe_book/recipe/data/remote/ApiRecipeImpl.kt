package com.example.recipe_book.recipe.data.remote

import com.example.recipe_book.recipe.domain.models.Recipe

class ApiRecipeImpl : ApiRecipe {
    override suspend fun getRecipesList(): List<Recipe> {
        val photos =
            listOf<String>("https://images.unsplash.com/photo-1554080353-a576cf803bda?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cGhvdG98ZW58MHx8MHx8fDA%3D")
        val r1 = Recipe(
            id = "4",
            title = "title1",
            photos = photos,
            userId = "32",
            ingredients = emptyList(),
            steps = emptyList(),
            likes = 20,
            comments = emptyList()
        )

        val r2 = Recipe(
            id = "4",
            title = "title2",
            photos = photos,
            userId = "32",
            ingredients = emptyList(),
            steps = emptyList(),
            likes = 20,
            comments = emptyList()
        )

        return listOf<Recipe>(r1, r2)
    }

    override suspend fun getRecipe(id: String): Recipe {
        TODO("Not yet implemented")
    }
}
package com.example.recipe_book.recipe.presentation.recipes_list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.recipe_book.recipe.presentation.recipes_list_screen.components.recipeCard
import com.example.recipe_book.recipe.presentation.util.components.LoadingDialog
import com.example.recipe_book.recipe.presentation.util.components.TopRecipeAppbar

@Composable
internal fun RecipeListScreen(
    viewModel: RecipeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    RecipeListContent(state = state)
}

@Composable
internal fun RecipeListContent(state: RecipeListViewState) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopRecipeAppbar(title = "Recipes") },
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = it.calculateTopPadding()),

            ) {
            items(state.recipeList) { recipe ->
                recipeCard(recipe = recipe)
            }
        }
    }
}
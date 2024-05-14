package com.example.recipe_book.recipe.presentation.recipes_list_screen

import androidx.compose.runtime.Composable
import com.example.recipe_book.recipe.domain.models.Recipe
import com.example.recipe_book.recipe.presentation.util.components.LoadingDialog

@Composable
internal fun RecipeListScreen(){

}

@Composable
internal fun RecipeListContent(state: RecipeListViewState){
    LoadingDialog(isLoading = state.isLoading)
}
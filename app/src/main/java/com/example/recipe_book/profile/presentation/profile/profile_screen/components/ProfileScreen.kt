package com.example.recipe_book.profile.presentation.profile.profile_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.recipe_book.R
import com.example.recipe_book.recipe.presentation.recipes_list_screen.components.recipeCard
import com.example.recipe_book.recipe.presentation.util.components.EnterButton
import com.example.recipe_book.recipe.presentation.util.components.LoadingDialog
import com.example.recipe_book.recipe.presentation.util.components.TopRecipeAppbar

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProfileContent(state = state)
}

@Composable
internal fun ProfileContent(state: ProfileViewState) {
    LoadingDialog(isLoading = state.isLoading)
    EnterButton(isSingIn = state.isSingIn)
    ProfileView(profile = state.profile!!)
    Scaffold(
        topBar = { TopRecipeAppbar(title = stringResource(id = R.string.your_rec)) },
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
        ) {
            if(state.userRecipes != null)
            {
                items(state.userRecipes!!) { recipe ->
                    recipeCard(recipe = recipe)
                }
            }
        }
    }
}
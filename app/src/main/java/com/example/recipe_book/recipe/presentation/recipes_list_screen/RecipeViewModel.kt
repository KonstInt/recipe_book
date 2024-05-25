package com.example.recipe_book.recipe.presentation.recipes_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_book.recipe.domain.repository.RecipeRepository
import com.example.recipe_book.recipe.presentation.util.components.sendEvent
import com.example.recipe_book.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(RecipeListViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            recipeRepository.getRecipesList()
                .onRight { recipeList ->
                    _state.update {
                        it.copy(recipeList = recipeList)
                    }
                }
                .onLeft { error ->
                    _state.update {
                        it.copy(error = error.error.message)

                    }
                    sendEvent(Event.Toast(error.error.message))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }


}
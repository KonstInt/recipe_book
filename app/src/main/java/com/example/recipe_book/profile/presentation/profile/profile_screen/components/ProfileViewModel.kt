package com.example.recipe_book.profile.presentation.profile.profile_screen.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_book.profile.domain.repository.ProfileRepository
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.example.recipe_book.recipe.domain.repository.RecipeRepository
import com.example.recipe_book.util.Event
import com.example.recipe_book.util.EventBus.sendEvent
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ProfileViewState())
    val state = _state.asStateFlow()

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            _state.update {
                it.copy(isSingIn = Firebase.auth.currentUser != null)
            }
            FirebaseAuth.getInstance().currentUser?.uid?.let {
                profileRepository.getProfile(it)
                    .onRight { profile ->
                        _state.update {
                            it.copy(profile = profile)
                        }
                    }
                    .onLeft { error ->
                        _state.update {
                            it.copy(error = error.error.message)
                        }
                        sendEvent(Event.Toast(error.error.message))
                    }
            }
            var recipes: List<RecipeLite> = listOf<RecipeLite>()
            state.value.profile?.recipes?.map { recipe ->
                recipeRepository.getRecipe(recipe)
                    .onRight { fullRecipe ->
                        recipes += RecipeLite(
                            fullRecipe.id!!,
                        fullRecipe.title!!,
                        fullRecipe.photos!!,
                        fullRecipe.userId!!,
                        fullRecipe.likes!!
                        )
                    }
                    .onLeft { null }
            }

            _state.update {
                it.copy(isLoading = false)
            }
        }
    }


}
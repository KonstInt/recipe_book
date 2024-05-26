package com.example.recipe_book.profile.presentation.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe_book.profile.domain.repository.ProfileRepository
import com.example.recipe_book.recipe.domain.repository.RecipeRepository
import com.example.recipe_book.recipe.presentation.recipes_list_screen.RecipeListViewState
import com.example.recipe_book.recipe.presentation.util.components.sendEvent
import com.example.recipe_book.util.Event
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
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
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }


}
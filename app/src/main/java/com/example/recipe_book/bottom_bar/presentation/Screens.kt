package com.example.recipe_book.bottom_bar.presentation

sealed class Screens(val screen: String) {
    data object Home : Screens("home")
    data object Profile : Screens("profile")
}
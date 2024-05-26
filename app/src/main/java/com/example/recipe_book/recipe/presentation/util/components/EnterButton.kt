package com.example.recipe_book.recipe.presentation.util.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text

@Composable
fun Enter(isSingIn: Boolean){
    if(!isSingIn){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center)
        {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Войти")
            }
        }
    }
}
package com.example.recipe_book.recipe.presentation.util.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import com.example.recipe_book.R

@Composable
fun EnterButton(isSingIn: Boolean){
    if(!isSingIn){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center)
        {
            Row {
                Button(onClick = { }) {
                    Text(text = stringResource(id = R.string.login_button))
                }
                Button(onClick = { }) {
                    Text(text = stringResource(id = R.string.singup_button))
                }
            }

        }
    }
}
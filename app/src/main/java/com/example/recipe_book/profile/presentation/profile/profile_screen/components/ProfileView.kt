package com.example.recipe_book.profile.presentation.profile.profile_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.recipe_book.R
import com.example.recipe_book.profile.domain.models.Profile
import com.example.recipe_book.recipe.domain.models.RecipeLite
import com.example.recipe_book.recipe.presentation.recipes_list_screen.components.recipeCard

@Composable
fun ProfileView(
    modifier: Modifier = Modifier,
    profile: Profile
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(verticalAlignment = Alignment.Top) {
                //Image(painter = , contentDescription = )
                Column {
                    Text(text = profile.name!!,         //жирным бы его выделить
                    )
                    Text(text = profile.email!!,
                        color = colorResource(id = R.color.gray)
                    )
                }
            }
        }
    }
}

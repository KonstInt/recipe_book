package com.example.recipe_book.recipe.presentation.recipes_list_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipe_book.recipe.domain.models.RecipeLite

@Composable
fun recipeCard(
    modifier: Modifier = Modifier,
    recipe: RecipeLite
) {
    Card(
        modifier = modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(contentColor = Color.Gray, containerColor = Color.Gray)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            AsyncImage(
                model = recipe.photos[0],
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 2f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = recipe.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}
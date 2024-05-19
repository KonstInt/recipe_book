package com.example.recipe_book.di

import com.example.recipe_book.recipe.data.repository.ApiRecipeRepository
import com.example.recipe_book.recipe.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: ApiRecipeRepository): RecipeRepository
}
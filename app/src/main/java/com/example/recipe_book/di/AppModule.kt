package com.example.recipe_book.di

import com.example.recipe_book.profile.data.remote.ApiProfile
import com.example.recipe_book.profile.data.remote.ApiProfileImpl
import com.example.recipe_book.recipe.data.remote.ApiRecipe
import com.example.recipe_book.recipe.data.remote.ApiRecipeImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideApiRecipe(): ApiRecipe {
        return ApiRecipeImpl()
    }

    @Provides
    @Singleton
    fun provideApiProfile(): ApiProfile {
        return ApiProfileImpl()
    }
}
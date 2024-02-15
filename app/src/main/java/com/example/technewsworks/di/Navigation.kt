package com.example.technewsworks.di

import com.example.technewsworks.ui.navigation.Navigator
import com.example.technewsworks.ui.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {
    @Provides
    @Singleton
    fun provideNavigation(): Navigator {
        return NavigatorImpl
    }
}
package com.manriquetavi.appgestor.di

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import com.manriquetavi.appgestor.domain.use_cases.get_all_stores.GetAllStoresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllStoresUseCase = GetAllStoresUseCase(repository)
        )
    }
}
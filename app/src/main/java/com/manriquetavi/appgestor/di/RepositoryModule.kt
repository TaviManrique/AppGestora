package com.manriquetavi.appgestor.di

import com.manriquetavi.appgestor.data.repository.Repository
import com.manriquetavi.appgestor.domain.use_cases.UseCases
import com.manriquetavi.appgestor.domain.use_cases.get_all_products_selected_store.GetAllProductsSelectedStoreUseCase
import com.manriquetavi.appgestor.domain.use_cases.get_all_stores.GetAllStoresUseCase
import com.manriquetavi.appgestor.domain.use_cases.get_selected_store.GetSelectedStoreUseCase
import com.manriquetavi.appgestor.domain.use_cases.sign_in.email_password.SignInWithEmailAndPassword
import com.manriquetavi.appgestor.domain.use_cases.sign_out_firebase.SignOutFirebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllStoresUseCase = GetAllStoresUseCase(repository),
            getSelectedStoreUseCase = GetSelectedStoreUseCase(repository),
            getAllProductsSelectedStoreUseCase = GetAllProductsSelectedStoreUseCase(repository),
            signInWithEmailAndPassword = SignInWithEmailAndPassword(repository),
            signOutFirebase = SignOutFirebase(repository)
        )
    }
}
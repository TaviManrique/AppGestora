package com.manriquetavi.appgestor.di

import com.google.firebase.firestore.FirebaseFirestore
import com.manriquetavi.appgestor.data.repository.FirebaseDataSourceImpl
import com.manriquetavi.appgestor.domain.repository.FirebaseDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideFirestoreDataSource(): FirebaseDataSource
    = FirebaseDataSourceImpl(queryAllStores = FirebaseFirestore.getInstance().collection("stores"))
}
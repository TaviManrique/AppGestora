package com.manriquetavi.appgestor.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import com.manriquetavi.appgestor.data.repository.FirebaseAuthSourceImpl
import com.manriquetavi.appgestor.data.repository.FirebaseDataSourceImpl
import com.manriquetavi.appgestor.domain.repository.FirebaseAuthSource
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


    //Firestore
    @Provides
    @Singleton
    fun provideFirestoreDataSource(): FirebaseDataSource = FirebaseDataSourceImpl(queryAllStores = FirebaseFirestore.getInstance().collection("stores"))

    //FirebaseAuth
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuthSource = FirebaseAuthSourceImpl(auth = Firebase.auth)
}
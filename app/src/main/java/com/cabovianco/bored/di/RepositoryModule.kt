package com.cabovianco.bored.di

import com.cabovianco.bored.data.repository.BoredRepositoryImpl
import com.cabovianco.bored.domain.repository.BoredRepository
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
    abstract fun bindTaskRepository(
        impl: BoredRepositoryImpl
    ): BoredRepository
}

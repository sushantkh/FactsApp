package com.sushant.factsapp.di

import android.content.Context
import com.sushant.factsapp.factslist.FactsRepository
import com.sushant.factsapp.network.FactsApiService
import com.sushant.factsapp.application.FactsApplication
import com.sushant.tmdbexample.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext app: Context): FactsApplication {
        return app as FactsApplication
    }

    @Provides
    fun provideFactsService(): FactsApiService =
        RetrofitService.retrofit.create(FactsApiService::class.java)

    @Provides
    fun provideHomeRepository(factsService: FactsApiService): FactsRepository =
        FactsRepository(factsService)


}
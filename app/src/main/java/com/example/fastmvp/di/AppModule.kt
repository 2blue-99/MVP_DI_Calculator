package com.example.fastmvp.di

import android.content.Context
import com.example.fastmvp.Module.MainModule
import com.example.fastmvp.contract.MainContract
import com.example.fastmvp.contract.SharedpreferenceModule
import com.example.fastmvp.presenter.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainPresenter(
        @ApplicationContext
        context: Context
    ): MainContract.Presenter =
        MainPresenter(provideSharedPreference(context))

    @Provides
    @Singleton
    fun provideSharedPreference(
        @ApplicationContext
        context: Context
    ): SharedpreferenceModule {
        return MainModule(context)
    }


}
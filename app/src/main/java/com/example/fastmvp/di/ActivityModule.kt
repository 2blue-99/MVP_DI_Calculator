package com.example.fastmvp.di

import com.example.fastmvp.contract.MainContract
import com.example.fastmvp.presenter.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideMainPresenter(): MainContract.Presenter = MainPresenter()
}
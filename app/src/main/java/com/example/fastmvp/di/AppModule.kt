package com.example.fastmvp.di

import android.content.Context
import com.example.fastmvp.Module.MainModule
import com.example.fastmvp.contract.MainContract
import com.example.fastmvp.contract.SharedpreferenceModule
import com.example.fastmvp.presenter.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module  //모듈은 provide, binds를 통해 주입할 클래스의 인스턴스를 생성
//@InstallIn(SingletonComponent::class) // 이건 무슨역할? 싱글톤??
//그리고 이걸 싱글톤에서 메인엑티비티로 바꿨는데 잘 됨. 왜그럴까
@InstallIn(SingletonComponent::class) // 싱글톤패턴이란?? >>
object AppModule { // 이게 오브젝트인 이유는?

    @Provides
//    @Singleton  싱글톤 없이도 잘 돌아간다 왜그럴까??
    fun provideMainPresenter(
        @ApplicationContext // 이게 무슨역할??
        context: Context
    ): MainContract.Presenter = MainPresenter(provideSharedPreference(context))
    // context가 왜 필요하다구?

    @Provides
//    @Singleton
    fun provideSharedPreference(
        @ApplicationContext
        context: Context
    ): SharedpreferenceModule { // 왜 이걸 따로 만들어주지?
        println("   AppModule   ")
        return MainModule(context)
    }


}
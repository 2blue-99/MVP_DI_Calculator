package com.example.fastmvp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // hilt를 사용하기 위해선 무조건 이러한 어노테이션을 가진
// application 클래스가 존재해야 함
class CalcApp: Application()
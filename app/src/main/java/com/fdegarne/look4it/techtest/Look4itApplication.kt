package com.fdegarne.look4it.techtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Look4itApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
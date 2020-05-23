package com.rohegde7.insiderevents

import android.app.Application
import android.content.Context

object InsiderApplication : Application() {

    lateinit var instance: InsiderApplication

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

/*
* 1. Application
* 2. Coroutines
* 3. MVVM
* 4. Kotlin
* 5. Glide
* 6. Live Data
* 7. Rx
*
* */
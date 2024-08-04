package com.iscoding.imagesdispatcher

import android.app.Application
import com.iscoding.imagesdispatcher.di.mviModule
import com.iscoding.imagesdispatcher.di.navigationModule
import com.iscoding.imagesdispatcher.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

class ImagesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ImagesApp)
            modules(repositoryModule,navigationModule, mviModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        // Optionally stop Koin when the application terminates
        stopKoin()
    }

}
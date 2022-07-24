package ru.trimok.films.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.trimok.films.main_activity.di.dataModule
import ru.trimok.films.main_activity.di.domainModule
import ru.trimok.films.main_activity.di.presentationModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, presentationModule))
        }
    }
}
package dev.mauricifj.github_kotlin_issues

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IssuesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@IssuesApplication)
            modules(listOf(issuesModule))
        }
    }
}
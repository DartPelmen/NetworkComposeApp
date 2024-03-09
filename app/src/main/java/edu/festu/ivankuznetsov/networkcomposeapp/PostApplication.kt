package edu.festu.ivankuznetsov.networkcomposeapp

import android.app.Application
import edu.festu.ivankuznetsov.networkcomposeapp.di.postModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PostApplication: Application(){
    //  lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        //  container = AppDataContainer(this)

        startKoin{
            androidLogger()
            androidContext(this@PostApplication)
            modules(postModule)
        }

    }
}
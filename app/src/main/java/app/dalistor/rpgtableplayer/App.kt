package app.dalistor.rpgtableplayer

import android.app.Application
import app.dalistor.rpgtableplayer.data.local.AppDatabase

class App : Application() {

    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
    }
}
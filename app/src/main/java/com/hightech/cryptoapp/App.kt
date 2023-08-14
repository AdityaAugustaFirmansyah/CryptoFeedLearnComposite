package com.hightech.cryptoapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.hightech.cryptoapp.crypto.feed.local.DatabaseLocal

class App : Application() {
    companion object{
        fun getDb(context: Context): DatabaseLocal {
            return Room.databaseBuilder(context, DatabaseLocal::class.java, "db")
                .build()
        }
    }
}
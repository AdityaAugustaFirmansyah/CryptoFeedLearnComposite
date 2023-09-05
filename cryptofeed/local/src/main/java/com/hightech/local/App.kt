package com.hightech.local

import android.app.Application
import android.content.Context
import androidx.room.Room

class App : Application() {
    companion object{
        fun getDb(context: Context): DatabaseLocal {
            return Room.databaseBuilder(context, DatabaseLocal::class.java, "db")
                .build()
        }
    }
}
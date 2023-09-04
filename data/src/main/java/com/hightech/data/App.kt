package com.hightech.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.hightech.data.local.DatabaseLocal

class App : Application() {
    companion object{
        fun getDb(context: Context): DatabaseLocal {
            return Room.databaseBuilder(context, DatabaseLocal::class.java, "db")
                .build()
        }
    }
}
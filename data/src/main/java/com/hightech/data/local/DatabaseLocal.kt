package com.hightech.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CryptoEntity::class], version = 1)
abstract class DatabaseLocal :RoomDatabase() {
    abstract fun cryptoDao(): CryptoDao
}
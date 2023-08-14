package com.hightech.cryptoapp.crypto.feed.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cryptoEntity: CryptoEntity)

    @Query("SELECT * FROM CryptoEntity LIMIT 1")
    suspend fun get():CryptoEntity
}
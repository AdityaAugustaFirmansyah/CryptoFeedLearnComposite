package com.hightech.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cryptoEntity: List<CryptoEntity>)

    @Query("SELECT * FROM CryptoEntity")
    suspend fun get():List<CryptoEntity>
}
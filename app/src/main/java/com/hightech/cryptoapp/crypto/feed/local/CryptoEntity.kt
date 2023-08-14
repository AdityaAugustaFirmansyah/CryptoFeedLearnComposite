package com.hightech.cryptoapp.crypto.feed.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoEntity(
    @PrimaryKey
    val id:Int = 1,
    val json:String,
    val req_date:Long
)
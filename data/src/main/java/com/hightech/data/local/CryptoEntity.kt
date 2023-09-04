package com.hightech.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoEntity(
    @PrimaryKey
    var id:String,
    var name:String,
    var fullName:String,
    var image:String,
    var price:Double,
    var changePctDay:Float
)
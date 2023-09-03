package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.local.CryptoEntity

interface SaveLocal{
    suspend fun save(data:List<CryptoEntity>)
}
package com.hightech.domain

interface SaveLocal{
    suspend fun save(data:List<CryptoFeedItem>)
}
package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.local.CryptoEntity
import com.hightech.cryptoapp.crypto.feed.local.DatabaseLocal

class InsertCryptoFeedLoader(val databaseLocal: DatabaseLocal) : SaveLocal {
    override suspend fun save(data: List<CryptoEntity>) {
        databaseLocal.cryptoDao().insert(data)
    }
}
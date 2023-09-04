package com.hightech.data.local.usecase

import com.hightech.data.mapper.CryptoFeedItemsMapper.Companion.toCryptoEntity
import com.hightech.data.local.DatabaseLocal
import com.hightech.domain.CryptoFeedItem
import com.hightech.domain.SaveLocal

class InsertCryptoFeedLoader(val databaseLocal: DatabaseLocal) : SaveLocal {
    override suspend fun save(data: List<CryptoFeedItem>) {
        databaseLocal.cryptoDao().insert(data.toCryptoEntity())
    }
}
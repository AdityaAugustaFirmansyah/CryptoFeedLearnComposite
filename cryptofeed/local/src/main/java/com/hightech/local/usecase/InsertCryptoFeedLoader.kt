package com.hightech.local.usecase

import com.hightech.local.DatabaseLocal
import com.hightech.domain.CryptoFeedItem
import com.hightech.domain.SaveLocal

class InsertCryptoFeedLoader(val databaseLocal: DatabaseLocal) : SaveLocal {
    override suspend fun save(data: List<CryptoFeedItem>) {
        databaseLocal.cryptoDao().insert(data.toCryptoEntity())
    }

    private fun List<CryptoFeedItem>.toCryptoEntity(): List<com.hightech.local.CryptoEntity> {
        return map {
            com.hightech.local.CryptoEntity(
                it.coinInfo.id,
                it.coinInfo.name,
                it.coinInfo.fullName,
                it.coinInfo.imageUrl,
                it.raw.usd.price,
                it.raw.usd.changePctDay
            )
        }
    }
}
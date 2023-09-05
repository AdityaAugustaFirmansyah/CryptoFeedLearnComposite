package com.hightech.local.usecase

import com.hightech.domain.CoinInfoItem
import com.hightech.domain.CryptoFeedItem
import com.hightech.domain.CryptoFeedLoader
import com.hightech.domain.CryptoFeedResult
import com.hightech.domain.RawItem
import com.hightech.domain.UsdItem
import com.hightech.local.DatabaseLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalCryptoFeedLoader (private val databaseLocal: DatabaseLocal): CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            val data = databaseLocal.cryptoDao().get()
            if (data.isEmpty()){
                emit(CryptoFeedResult.Failure(Throwable("Tidak Ada Ada")))
            }else{
                emit(CryptoFeedResult.Success(data.toCryptoDomain()))
            }
        }
    }

    private fun List<com.hightech.local.CryptoEntity>.toCryptoDomain(): List<CryptoFeedItem> {
        return map {
            CryptoFeedItem(
                CoinInfoItem(
                    it.id,
                    it.name,
                    it.fullName,
                    it.image
                ),
                RawItem(
                    UsdItem(
                        it.price,
                        it.changePctDay
                    )
                )
            )
        }
    }
}
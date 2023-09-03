package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper.Companion.toCryptoDomain
import com.hightech.domain.CryptoFeedLoader
import com.hightech.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.local.DatabaseLocal
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
}
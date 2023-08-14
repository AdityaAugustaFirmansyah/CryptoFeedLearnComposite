package com.hightech.cryptoapp.crypto.feed.local.usecase

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.RemoteCryptoFeedItem
import com.hightech.cryptoapp.crypto.feed.local.CryptoEntity
import com.hightech.cryptoapp.crypto.feed.local.DatabaseLocal
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalCryptoFeedLoader (val databaseLocal: DatabaseLocal):CryptoFeedLoader{
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            val data = databaseLocal.cryptoDao().get()
            if (data.json.isEmpty()){
                emit(CryptoFeedResult.Failure((Throwable("not found"))))
            }else{
                val adapter:JsonAdapter<List<RemoteCryptoFeedItem>> = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter<List<RemoteCryptoFeedItem>>(Types.newParameterizedType(List::class.java,RemoteCryptoFeedItem::class.java))
                val array = adapter.fromJson(data.json)
                if (array.isNullOrEmpty()){
                    emit(CryptoFeedResult.Failure(Throwable("not found")))
                }else{
                    emit(CryptoFeedResult.Success(CryptoFeedItemsMapper.map(array)))
                }

            }
        }
    }

    suspend fun insert(data: List<RemoteCryptoFeedItem>) {
        val adapter:JsonAdapter<List<RemoteCryptoFeedItem>> = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter<List<RemoteCryptoFeedItem>>(Types.newParameterizedType(List::class.java,RemoteCryptoFeedItem::class.java))
        val array = adapter.toJson(data)
        val entity = CryptoEntity(1,array,System.currentTimeMillis())
        databaseLocal.cryptoDao().insert(entity)
    }

}
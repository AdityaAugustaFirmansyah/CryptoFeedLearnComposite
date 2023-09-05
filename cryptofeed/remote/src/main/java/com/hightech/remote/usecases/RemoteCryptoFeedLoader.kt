package com.hightech.remote.usecases

import android.util.Log
import com.hightech.domain.CoinInfoItem
import com.hightech.domain.Connectivity
import com.hightech.domain.CryptoFeedItem
import com.hightech.domain.CryptoFeedLoader
import com.hightech.domain.CryptoFeedResult
import com.hightech.domain.InvalidData
import com.hightech.domain.RawItem
import com.hightech.domain.UsdItem
import com.hightech.remote.ConnectivityException
import com.hightech.remote.CryptoFeedHttpClient
import com.hightech.remote.HttpClientResult
import com.hightech.remote.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteCryptoFeedLoader constructor(
    private val cryptoFeedHttpClient: CryptoFeedHttpClient,
) :
    CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> = flow {
        cryptoFeedHttpClient.get().collect { result ->
            when (result) {
                is HttpClientResult.Success -> {
                    val cryptoFeed = result.root.data
                    if (cryptoFeed.isNotEmpty()) {
                        emit(CryptoFeedResult.Success(map(cryptoFeed)))
                    } else {
                        emit(CryptoFeedResult.Success(emptyList()))
                    }
                }

                is HttpClientResult.Failure -> {
                    Log.d("loadCryptoFeed", "Failure")
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(CryptoFeedResult.Failure(Connectivity()))
                        }

                        is InvalidDataException -> {
                            Log.d("loadCryptoFeed", "InvalidData")
                            emit(CryptoFeedResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }

    fun map(items: List<com.hightech.remote.RemoteCryptoFeedItem>): List<CryptoFeedItem> {
        return items.map {
            CryptoFeedItem(
                coinInfo = CoinInfoItem(
                    it.remoteCoinInfo.id.orEmpty(),
                    it.remoteCoinInfo.name.orEmpty(),
                    it.remoteCoinInfo.fullName.orEmpty(),
                    it.remoteCoinInfo.imageUrl.orEmpty()
                ),
                raw = RawItem(
                    usd = UsdItem(
                        it.remoteRaw.usd.price ?: 0.0,
                        it.remoteRaw.usd.changePctDay ?: 0F
                    )
                )
            )
        }
    }

}


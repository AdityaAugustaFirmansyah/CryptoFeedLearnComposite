package com.hightech.cryptoapp.composite

import android.content.Context
import android.net.ConnectivityManager
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedLoader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CryptoComposite(private val remote:CryptoFeedLoader ,private val local: CryptoFeedLoader):CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {

        return flow {
            val result = remote.load().first()
            if( result is CryptoFeedResult.Failure){
                emit(local.load().first())
            }else{
                emit(result)
            }
        }
    }

}
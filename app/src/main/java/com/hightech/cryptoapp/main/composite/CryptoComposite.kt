package com.hightech.cryptoapp.main.composite

import com.hightech.domain.CryptoFeedLoader
import com.hightech.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CryptoComposite(private val remote: CryptoFeedLoader, private val local: CryptoFeedLoader):
    CryptoFeedLoader {
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
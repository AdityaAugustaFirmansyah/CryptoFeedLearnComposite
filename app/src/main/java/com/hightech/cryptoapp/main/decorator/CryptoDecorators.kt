package com.hightech.cryptoapp.main.decorator

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper.Companion.toCryptoEntity
import com.hightech.domain.CryptoFeedLoader
import com.hightech.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.local.usecase.SaveLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun createCryptoDecoratorsFactory(decorators: CryptoFeedLoader, saveLocal: SaveLocal):CryptoDecorators{
    return CryptoDecorators(decorators,saveLocal)
}

class CryptoDecorators(
    val decorate: CryptoFeedLoader,
    val saveLocal: SaveLocal
) : CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> = flow {
        decorate.load().collect{
            if (it is CryptoFeedResult.Success){
                saveLocal.save(it.cryptoFeedItems.toCryptoEntity())
            }
            emit(it)
        }
    }

}
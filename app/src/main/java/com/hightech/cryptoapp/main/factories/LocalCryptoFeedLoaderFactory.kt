package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.local.DatabaseLocal
import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object{
        fun createLocalCryptoFeedLoader(databaseLocal: DatabaseLocal):LocalCryptoFeedLoader{
            return LocalCryptoFeedLoader(databaseLocal)
        }
    }
}
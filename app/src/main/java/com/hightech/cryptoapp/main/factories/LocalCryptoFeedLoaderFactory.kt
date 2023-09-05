package com.hightech.cryptoapp.main.factories

import com.hightech.local.DatabaseLocal
import com.hightech.local.usecase.InsertCryptoFeedLoader
import com.hightech.local.usecase.LocalCryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object{
        fun createLocalCryptoFeedLoader(databaseLocal: DatabaseLocal): LocalCryptoFeedLoader {
            return LocalCryptoFeedLoader(databaseLocal)
        }

        fun createInsertLocalCryptoFeedLoader(databaseLocal: DatabaseLocal): InsertCryptoFeedLoader {
            return InsertCryptoFeedLoader(databaseLocal)
        }
    }
}
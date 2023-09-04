package com.hightech.cryptoapp.main.factories

import com.hightech.data.local.DatabaseLocal
import com.hightech.data.local.usecase.InsertCryptoFeedLoader
import com.hightech.data.local.usecase.LocalCryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object{
        fun createLocalCryptoFeedLoader(databaseLocal: com.hightech.data.local.DatabaseLocal): LocalCryptoFeedLoader {
            return LocalCryptoFeedLoader(databaseLocal)
        }

        fun createInsertLocalCryptoFeedLoader(databaseLocal: com.hightech.data.local.DatabaseLocal): InsertCryptoFeedLoader {
            return InsertCryptoFeedLoader(databaseLocal)
        }
    }
}
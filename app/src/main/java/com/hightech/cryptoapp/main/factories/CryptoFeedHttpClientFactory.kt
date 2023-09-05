package com.hightech.cryptoapp.main.factories

import com.hightech.remote.CryptoFeedHttpClient
import com.hightech.remote.CryptoFeedRetrofitHttpClient

class CryptoFeedHttpClientFactory {
    companion object {
        fun createCryptoFeedHttpClient(): com.hightech.remote.CryptoFeedHttpClient {
            return com.hightech.remote.CryptoFeedRetrofitHttpClient(
                CryptoFeedServiceFactory.createCryptoFeedService()
            )
        }
    }
}
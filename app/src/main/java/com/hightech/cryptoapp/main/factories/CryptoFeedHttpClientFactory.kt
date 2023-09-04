package com.hightech.cryptoapp.main.factories

import com.hightech.data.http.CryptoFeedHttpClient
import com.hightech.data.http.CryptoFeedRetrofitHttpClient

class CryptoFeedHttpClientFactory {
    companion object {
        fun createCryptoFeedHttpClient(): com.hightech.data.http.CryptoFeedHttpClient {
            return CryptoFeedRetrofitHttpClient(
                CryptoFeedServiceFactory.createCryptoFeedService()
            )
        }
    }
}
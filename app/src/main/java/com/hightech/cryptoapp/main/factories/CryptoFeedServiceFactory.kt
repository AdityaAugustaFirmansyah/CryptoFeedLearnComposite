package com.hightech.cryptoapp.main.factories

import com.hightech.remote.frameworks.HttpFactory
import com.hightech.remote.CryptoFeedService

class CryptoFeedServiceFactory {
    companion object {
        fun createCryptoFeedService(): CryptoFeedService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(CryptoFeedService::class.java)
        }
    }
}
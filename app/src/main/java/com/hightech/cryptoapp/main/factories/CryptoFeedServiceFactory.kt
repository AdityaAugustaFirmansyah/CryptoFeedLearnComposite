package com.hightech.cryptoapp.main.factories

import com.hightech.data.frameworks.HttpFactory
import com.hightech.data.http.CryptoFeedService

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
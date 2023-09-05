package com.hightech.cryptoapp.main.factories

import com.hightech.domain.CryptoFeedLoader
import com.hightech.remote.usecases.RemoteCryptoFeedLoader

class RemoteCryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
            )
        }
    }
}
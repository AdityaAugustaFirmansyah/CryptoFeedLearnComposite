package com.hightech.cryptoapp.main.factories

import android.app.Application
import android.content.Context
import com.hightech.cryptoapp.App
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader

class RemoteCryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(context: Context): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
                LocalCryptoFeedLoaderFactory.createLocalCryptoFeedLoader(App.getDb(context))
            )
        }
    }
}
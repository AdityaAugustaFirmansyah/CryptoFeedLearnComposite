package com.hightech.cryptoapp.main.factories

import android.content.Context
import com.hightech.data.App
import com.hightech.domain.CryptoFeedLoader
import com.hightech.cryptoapp.main.composite.CryptoComposite
import com.hightech.cryptoapp.main.decorator.createCryptoDecoratorsFactory

class CryptoFeedCompositeFactory {
    companion object{
        fun createFeedCompositeFactory(context: Context): CryptoFeedLoader {
            return CryptoComposite(
                remote = createCryptoDecoratorsFactory(
                    decorators = RemoteCryptoFeedLoaderFactory.createRemoteCryptoFeedLoader(),
                    saveLocal = LocalCryptoFeedLoaderFactory.createInsertLocalCryptoFeedLoader(App.getDb(context))
                ),
                local = LocalCryptoFeedLoaderFactory.createLocalCryptoFeedLoader(App.getDb(context))
            )
        }
    }
}
package com.hightech.cryptoapp.composite

import android.content.Context
import android.net.ConnectivityManager
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.local.usecase.LocalCryptoFeedLoader
import kotlinx.coroutines.flow.Flow

class CryptoComposite(private val remote:CryptoFeedLoader ,private val local: CryptoFeedLoader,val context: Context):CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        val connect:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connect.activeNetwork
        val actNw = connect.getNetworkCapabilities(info)
        return if (actNw!=null){
            remote.load()
        }else{
            local.load()
        }
    }

}
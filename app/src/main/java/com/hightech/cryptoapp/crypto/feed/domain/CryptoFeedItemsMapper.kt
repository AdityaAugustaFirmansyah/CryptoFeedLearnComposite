package com.hightech.cryptoapp.crypto.feed.domain

import com.hightech.cryptoapp.crypto.feed.http.RemoteCryptoFeedItem
import com.hightech.cryptoapp.crypto.feed.local.CryptoEntity
import com.hightech.domain.CoinInfoItem
import com.hightech.domain.CryptoFeedItem
import com.hightech.domain.RawItem
import com.hightech.domain.UsdItem

class CryptoFeedItemsMapper {
    companion object {
        fun map(items: List<RemoteCryptoFeedItem>): List<CryptoFeedItem> {
            return items.map {
                CryptoFeedItem(
                    coinInfo = CoinInfoItem(
                        it.remoteCoinInfo.id.orEmpty(),
                        it.remoteCoinInfo.name.orEmpty(),
                        it.remoteCoinInfo.fullName.orEmpty(),
                        it.remoteCoinInfo.imageUrl.orEmpty()
                    ),
                    raw = RawItem(
                        usd = UsdItem(
                            it.remoteRaw.usd.price ?: 0.0,
                            it.remoteRaw.usd.changePctDay ?: 0F
                        )
                    )
                )
            }
        }

        fun List<CryptoFeedItem>.toCryptoEntity(): List<CryptoEntity> {
            return map {
                CryptoEntity(
                    it.coinInfo.id,
                    it.coinInfo.name,
                    it.coinInfo.fullName,
                    it.coinInfo.imageUrl,
                    it.raw.usd.price,
                    it.raw.usd.changePctDay
                )
            }
        }

        fun List<CryptoEntity>.toCryptoDomain(): List<CryptoFeedItem> {
            return map {
                CryptoFeedItem(
                    CoinInfoItem(
                        it.id,
                        it.name,
                        it.fullName,
                        it.image
                    ),
                    RawItem(
                        UsdItem(
                            it.price,
                            it.changePctDay
                        )
                    )
                )
            }
        }
    }
}
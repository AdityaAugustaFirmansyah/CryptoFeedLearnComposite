package com.hightech.cryptoapp.main.factories

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.hightech.presentation.CryptoFeedViewModel

object CryptoViewModelFactory {
    fun factory(app: Context): ViewModelProvider.Factory{
        return viewModelFactory {
            addInitializer(CryptoFeedViewModel::class){
                CryptoFeedViewModel(
                    CryptoFeedCompositeFactory.createFeedCompositeFactory(app)
                )
            }
        }
    }
}
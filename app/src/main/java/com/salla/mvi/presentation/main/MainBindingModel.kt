package com.salla.mvi.presentation.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.architect.mvi.adapter.GenericListAdapter
import com.salla.mvi.R
import com.salla.mvi.domain.repository.NewsItem

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 */
class MainBindingModel : BaseObservable() {

    @Bindable
    var text: String = "Title"
        set(text) {
            field = text
            notifyPropertyChanged(BR.text)
        }

    @Bindable
    var refresh: Boolean = false
        set(refresh) {
            field = refresh
            notifyPropertyChanged(BR.refresh)
        }

    val newsAdapter by lazy {
        GenericListAdapter(
            layoutId = R.layout.item_view,
            diffUtil = NewsItem.Companion.NewsItemItemCallback
        )
    }


}
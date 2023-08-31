package com.salla.mvi.presentation.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.load
import com.salla.mvi.R
import com.salla.mvi.presentation.features.main.MainViewActions
import com.salla.mvi.presentation.features.main.MainViewModel

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 */

@BindingAdapter("bind:swipe_refresh", "swipe_controller")
fun swipeRefresh(
    swipeRefresh: SwipeRefreshLayout?,
    isRefreshing: Boolean,
    viewModel: MainViewModel
) {
    swipeRefresh?.let {
        swipeRefresh.isRefreshing = isRefreshing
        swipeRefresh.setOnRefreshListener {
            viewModel.handleActions(MainViewActions.OnSwipeRefresh)
        }
    }
}

@BindingAdapter("bind:img_url")
fun imgUrl(
    img: AppCompatImageView?,
    url: String,
) {
    img?.let {
        img.load(url) {
            crossfade(true)
            placeholder(R.drawable.placeholder)
        }
    }
}
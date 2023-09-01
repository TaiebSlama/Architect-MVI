package com.salla.mvi.presentation.features.main

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

sealed class MainViewState {
    data class LoadNews(val newsList: List<NewsItem> = emptyList()) : MainViewState()
    data object Fetching : MainViewState()
    data object Fetched : MainViewState()
    data class ShowToast(val message: String = "") : MainViewState()
    data class UpdateTitle(val message: String = "") : MainViewState()
}

sealed class MainViewActions {
    data class NewsItemClicked(val newsItem: NewsItem = NewsItem()) : MainViewActions()
    data object IncrementTitle : MainViewActions()
    data object OnSwipeRefresh : MainViewActions()
    data object FetchNews : MainViewActions()
}
package com.salla.mvi.presentation.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.architect.mvi.viewModel.MVIViewModel
import com.salla.mvi.domain.helpers.LCE
import com.salla.mvi.domain.repository.NewsItem
import com.salla.mvi.domain.repository.NewsRepository
import kotlinx.coroutines.launch

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 */
class MainViewModel(application: Application) :
    MVIViewModel<MainViewState, MainViewActions>(application) {
    private var count: Int = 0
    private val repository: NewsRepository = NewsRepository.getInstance()

    override fun initAttributes() {
        handleActions(MainViewActions.FetchNews)
    }

    override fun handleActions(viewAction: MainViewActions) {
        when (viewAction) {
            is MainViewActions.NewsItemClicked -> newsItemClicked(viewAction.newsItem)
            MainViewActions.IncrementTitle -> incrementTitle()
            MainViewActions.OnSwipeRefresh -> fetchNews()
            MainViewActions.FetchNews -> fetchNews()
        }
    }

    private fun newsItemClicked(newsItem: NewsItem) {
        viewState = MainViewState.ShowToast(newsItem.title)
    }

    private fun incrementTitle() {
        count++
        viewState = MainViewState.UpdateTitle(message = "Title $count")
    }

    private fun fetchNews() {
        viewState = MainViewState.Fetching
        repository.getMockApiResponse { result ->
            when (result) {
                is LCE.Error -> {
                    viewModelScope.launch {
                        viewState = MainViewState.Fetched
                        viewState = MainViewState.ShowToast(message = result.message)
                    }
                }

                is LCE.Success -> {
                    viewModelScope.launch {
                        viewState = MainViewState.Fetched
                        viewState = MainViewState.LoadNews(newsList = result.data)
                    }
                }
            }
        }

    }
}
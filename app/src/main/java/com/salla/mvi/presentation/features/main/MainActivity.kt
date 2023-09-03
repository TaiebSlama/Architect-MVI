package com.salla.mvi.presentation.features.main

import androidx.activity.viewModels
import com.architect.mvi.activity.MVIActivity
import com.salla.mvi.R
import com.salla.mvi.databinding.ActivityMainBinding
import com.salla.mvi.presentation.utils.toast

/**
 *  Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 *  Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 * viewModel [MainViewModel]
 * View state [MainViewState]
 * Events [MainViewActions]
 * */
class MainActivity :
    MVIActivity<MainViewState, MainViewActions, MainViewModel, ActivityMainBinding>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    lateinit var bindingModel: MainBindingModel

    override fun configDataBinding(bindingView: ActivityMainBinding?) {
        bindingModel = MainBindingModel()
        bindingView?.controller = this
    }

    override fun renderViewState(viewState: MainViewState) {
        when (viewState) {
            is MainViewState.LoadNews -> bindingModel.newsAdapter.submitList(viewState.newsList)
            is MainViewState.ShowToast -> toast(viewState.message)
            is MainViewState.UpdateTitle -> bindingModel.text = viewState.message
            MainViewState.Fetched -> bindingModel.refresh = false
            MainViewState.Fetching -> bindingModel.refresh = true
        }
    }

    fun handleIncrementTitle() {
        viewModel.handleActions(MainViewActions.IncrementTitle)
    }

}


/*
 * Copyright 2021 Rohit Surwase
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.architect.mvi.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.architect.mvi.util.TAG
import com.architect.mvi.viewModel.MVIViewModel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 * Create Activities by extending this class.
 *
 * Also @see [MVIViewModel] for [STATE] and [EVENT] explanation.
 * @param ViewModel Respective ViewModel class for this activity which extends [MVIViewModel]
 *
 */
abstract class MVIActivity<STATE, EVENT, ViewModel : MVIViewModel<STATE, EVENT>, VDB : ViewDataBinding>(
    private var layoutId: Int
) :
    AppCompatActivity() {

    abstract val viewModel: ViewModel

    private var bindingView: VDB? = null

    private val viewStateCollector = FlowCollector<STATE?> {
        it?.let {
            Log.d(TAG, it.toString())
            renderViewState(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LayoutInflater.from(this).inflate(layoutId, null, false)
        bindingView = DataBindingUtil.bind(root)
        setContentView(root)
        configDataBinding(bindingView)
        lifecycleScope.launch {
            viewModel.viewStates().collect(viewStateCollector)
        }
        viewModel.initAttributes()
    }

    abstract fun renderViewState(viewState: STATE)
    abstract fun configDataBinding(bindingView: VDB?)

}
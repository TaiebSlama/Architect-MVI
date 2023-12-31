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

package com.architect.mvi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
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
 * Create Fragments by extending this class.
 *
 * Also @see [MVIViewModel] for [STATE] and [EVENT] explanation.
 * @param ViewModel ViewModel class for this Fragment which
 *   extends [MVIViewModel]
 *
 */
abstract class MVIFragment<STATE, EVENT, ViewModel : MVIViewModel<STATE, EVENT>, VDB : ViewDataBinding>(
    private val layoutId: Int
) :
    Fragment() {

    abstract val viewModel: ViewModel

    private var bindingView: VDB? = null

    private val viewStateCollector = FlowCollector<STATE?> {
        it?.let {
            Log.d(TAG, "observed viewState : $it")
            renderViewState(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates().collect(viewStateCollector)
        }
        bindingView = DataBindingUtil.bind(view)
        configDataBinding(bindingView)
    }

    abstract fun configDataBinding(bindingView: VDB?)

    abstract fun renderViewState(viewState: STATE)

}
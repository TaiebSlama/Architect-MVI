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

package com.architect.mvi.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.architect.mvi.util.TAG
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 */

abstract class MVIViewModel<STATE, ACTION>(application: Application) :
    AndroidViewModel(application) {

    private val _viewStates: MutableStateFlow<STATE?> = MutableStateFlow(null)
    internal fun viewStates(): StateFlow<STATE?> = _viewStates

    private var _viewState: STATE? = null
    protected var viewState: STATE
        get() = _viewState
            ?: throw UninitializedPropertyAccessException("\"viewState\" was queried before being initialized. You must initialize \"viewState\" inside init{} block")
        set(value) {
            _viewState = value
            _viewStates.value = value
        }

    abstract fun initAttributes()

    abstract fun handleActions(viewAction: ACTION)

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }
}
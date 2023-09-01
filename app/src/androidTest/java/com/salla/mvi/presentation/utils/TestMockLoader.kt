package com.salla.mvi.presentation.utils

/**
 * Created by taieb.slama@zeta-box.com on 9/1/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 */
abstract class TestMockLoader<VS> {
    abstract fun loadMockData(viewState: VS)

}
package com.salla.mvi.presentation.app

import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.core.module.Module

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
class KoinTestRule(
    private val modules: List<Module>
) : TestWatcher() {
    override fun starting(description: Description) {
        TestMVIApp.instance.koinApplication.modules(modules)
//        loadKoinModules(modules)
    }

    override fun finished(description: Description) {
        stopKoin()
    }
}
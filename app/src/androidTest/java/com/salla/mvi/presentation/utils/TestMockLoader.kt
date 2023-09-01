package com.salla.mvi.presentation.utils

/**
 * Created by taieb.slama@zeta-box.com on 9/1/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
abstract class TestMockLoader<VS> /*: TestWatcher() */ {

    abstract fun loadMockData(viewState: VS)

//    override fun starting(description: Description) {
//        TestMVIApp.instance.koinApplication = GlobalContext.startKoin {
//            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
//            modules(loadMockData(viewState : VS))
//        }
//    }
//
//    override fun finished(description: Description) {
//        GlobalContext.stopKoin()
//    }

}
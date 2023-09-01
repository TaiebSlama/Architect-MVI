package com.salla.mvi.presentation.app

import com.salla.mvi.domain.repository.INewsRepository
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.mockito.Mockito.mock


/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */

class TestMVIApp : MVIApp() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun initKoin() {
        koinApplication = startKoin {
            modules(testModule)
        }
    }

    companion object {
        lateinit var instance: MVIApp
    }
}


val testModule = module {
    single<INewsRepository> { mock() }
}

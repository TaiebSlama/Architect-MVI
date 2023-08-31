package com.salla.mvi.presentation.app

import android.app.Application
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
open class MVIApp : Application() {

    internal lateinit var koinApplication: KoinApplication

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    open fun initKoin() {
        koinApplication = startKoin {
            modules(appModule)
        }
    }
}
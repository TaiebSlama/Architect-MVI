package com.salla.mvi.presentation.app

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
class MVIApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}
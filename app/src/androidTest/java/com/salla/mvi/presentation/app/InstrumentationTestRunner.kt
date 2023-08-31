package com.salla.mvi.presentation.app

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.test.runner.AndroidJUnitRunner

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
class InstrumentationTestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(arguments)
    }

    override fun newApplication(
        classLoader: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        Log.d("Test", "InstrumentationTestRunner")
        return super.newApplication(classLoader, TestMVIApp::class.java.name, context)
    }
}
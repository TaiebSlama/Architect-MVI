package com.salla.mvi.presentation.app

import com.salla.mvi.domain.repository.INewsRepository
import com.salla.mvi.domain.repository.NewsRepository
import org.koin.dsl.module

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
val instrumentedTestModule = module {
    factory<INewsRepository> { NewsRepository() }
}
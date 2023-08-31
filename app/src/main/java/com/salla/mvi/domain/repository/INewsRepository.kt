package com.salla.mvi.domain.repository

import com.salla.mvi.domain.helpers.LCE

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [NewsRepository]
 */
interface INewsRepository {

    fun getMockApiResponse(callback: (LCE<List<NewsItem>>) -> Unit)
}
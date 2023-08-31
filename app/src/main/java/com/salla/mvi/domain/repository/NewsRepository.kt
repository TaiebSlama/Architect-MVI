package com.salla.mvi.domain.repository

import com.salla.mvi.domain.helpers.LCE
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Created by slama.taieb.contact@gmail.com on 8/30/2023 .
 * Copyright (c) 2023. All rights reserved.
 *
 * @author Slama Taieb
 * @version 1.0
 * @since 1.0
 *
 */

class NewsRepository : INewsRepository {


    override suspend fun getMockApiResponse(): LCE<List<NewsItem>> {
        val fakeNews = constructMockData()
        delay(2000)
        return LCE.Success(data = fakeNews)
    }

    private fun constructMockData(): List<NewsItem> {
        val newsList = mutableListOf<NewsItem>()
        for (i in 1..4) {
            val title = "News$i"
            val description = "News$i Description"
            val imageId = Random.nextInt(1, 1000)
            val imageUrl = "https://picsum.photos/200/300?image=$imageId"
            val news = NewsItem(title, description, imageUrl)
            newsList.add(news)
        }
        return newsList
    }
}
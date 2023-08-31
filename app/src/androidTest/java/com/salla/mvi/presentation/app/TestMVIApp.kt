package com.salla.mvi.presentation.app

import com.salla.mvi.domain.helpers.LCE
import com.salla.mvi.domain.repository.INewsRepository
import com.salla.mvi.domain.repository.NewsItem
import com.salla.mvi.domain.repository.NewsRepository
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.mockito.Mockito.mock
import org.mockito.stubbing.Answer
import kotlin.random.Random


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
    single<INewsRepository> { createMockNewRepository() }
}

fun createMockNewRepository(): NewsRepository {
    val model = mock<NewsRepository>()
    val answer: Answer<LCE<List<NewsItem>>> = Answer<LCE<List<NewsItem>>> { _ ->
        val newsList = mutableListOf<NewsItem>()
        for (i in 1..2) {
            val title = "News Test $i"
            val description = "News Test $i Description"
            val imageId = Random.nextInt(1, 1000)
            val imageUrl = "https://picsum.photos/200/300?image=$imageId"
            val news = NewsItem(title, description, imageUrl)
            newsList.add(news)
        }
        LCE.Success(newsList)
    }
//    doAnswer(answer).`when`(model.getMockApiResponse {  })
    return model
}
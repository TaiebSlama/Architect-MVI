package com.salla.mvi.presentation.features.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.salla.mvi.R
import com.salla.mvi.domain.helpers.LCE
import com.salla.mvi.domain.repository.INewsRepository
import com.salla.mvi.domain.repository.NewsItem
import com.salla.mvi.presentation.app.TestMVIApp
import com.salla.mvi.presentation.utils.TestMockLoader
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.module
import org.mockito.Mockito
import kotlin.random.Random

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
@RunWith(AndroidJUnit4::class)
class MainTest : TestMockLoader<MainViewState>() {

    private fun mainTestModule(state: String) = module {
        single { createMockNewRepository(state) }
    }

    private fun createMockNewRepository(state: String): INewsRepository {
        val model = Mockito.mock<INewsRepository>()
        val newsList = mutableListOf<NewsItem>()
        for (i in 1..4) {
            val title = "News Test $i"
            val description = "News $state"
            val imageId = Random.nextInt(1, 1000)
            val imageUrl = "https://picsum.photos/200/300?image=$imageId"
            val news = NewsItem(title, description, imageUrl)
            newsList.add(news)
        }
        runBlocking {
            Mockito.`when`(model.getMockApiResponse()).thenReturn(LCE.Success(newsList))
        }
        return model
    }

    @get:Rule
    var mActivityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun activityMain_test_state_Fetched() {
        loadMockData(MainViewState.Fetched)
        val count = 15
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }

    @Test
    fun activityMain_test_state_Fetching() {
        loadMockData(MainViewState.Fetching)
        val count = 15
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }

    @Test
    fun activityMain_test_state_LoadNews() {
        loadMockData(MainViewState.LoadNews())
        val count = 15
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }

    @Test
    fun activityMain_test_state_ShowToast() {
        loadMockData(MainViewState.ShowToast())
        val count = 15
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }

    @Test
    fun activityMain_test_state_UpdateTitle() {
        loadMockData(MainViewState.UpdateTitle())
        val count = 15
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }

    override fun loadMockData(viewState: MainViewState) {
        val modules = when (viewState) {
            MainViewState.Fetched -> listOf(mainTestModule("Fetched"))
            MainViewState.Fetching -> listOf(mainTestModule("Fetching"))
            is MainViewState.LoadNews -> listOf(mainTestModule("LoadNews"))
            is MainViewState.ShowToast -> listOf(mainTestModule("ShowToast"))
            is MainViewState.UpdateTitle -> listOf(mainTestModule("UpdateTitle"))
        }
        TestMVIApp.instance.koinApplication.modules(modules)
    }

}
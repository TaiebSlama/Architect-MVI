package com.salla.mvi.presentation.features.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.salla.mvi.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by taieb.slama@zeta-box.com on 8/31/2023 .
 * Copyright (c) 2023 ZETA-BOX. All rights reserved.
 *
 * [ADD DESCRIPTION]
 */
@RunWith(AndroidJUnit4::class)
class MainTest {

//    @get:Rule
//    val koinTestRule = KoinTestRule(
//        modules = listOf(testModule)
//    )

    @get:Rule
    var mActivityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun activityMain_test_increment_title_success_case() {
        val count = 20
        (1..count).forEach { _ ->
            onView(withId(R.id.increment_button_button)).perform(click())
        }
        onView(withId(R.id.activity_main_title)).check(matches(withText("Title $count")))
    }
}
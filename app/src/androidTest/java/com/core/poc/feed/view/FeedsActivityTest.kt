package com.core.poc.feed.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.core.poc.R
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class FeedsActivityTest{

    @get:Rule
    var mActivityTestRule = ActivityTestRule(FeedsActivity::class.java)

    @Test
    fun displayData() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_feeds)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun testRefresh() { //Before refresh there is a list .
        Espresso.onView(ViewMatchers.withId(R.id.rv_feeds)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))

      /*  // do refresh .
        Espresso.onView(ViewMatchers.withId(R.id.swipe_refresh_view)).perform(ViewActions.click())*/
        //after refresh there is a list.
        Espresso.onView(ViewMatchers.withId(R.id.rv_feeds)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))

    }

}
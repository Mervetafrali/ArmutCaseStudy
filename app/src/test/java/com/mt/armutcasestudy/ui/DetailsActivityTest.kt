package com.mt.armutcasestudy.ui


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
class DetailsActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun listGoesOverTheFold() {
       // onView(withId("Hello world!")).check(matches(isDisplayed()))
    }
}
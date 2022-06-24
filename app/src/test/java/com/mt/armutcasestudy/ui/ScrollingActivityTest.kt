package com.mt.armutcasestudy.ui

import com.mt.armutcasestudy.repository.ApiRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class ScrollingActivityTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: ApiRepository

    @Before
    fun setUp(){
        hiltRule.inject()
    }
    @Test
    fun some() {

    }
}
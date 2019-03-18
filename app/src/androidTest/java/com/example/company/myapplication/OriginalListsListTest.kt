package com.example.company.myapplication

import android.widget.ArrayAdapter
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.company.myapplication.MainActivity
import com.example.company.myapplication.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class OriginalListsListTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun findInExisting() {
        val firstName = "первый список"
        check(activityRule.activity.dataHolder.getListsNames().contains(firstName))
        onView(withText(firstName)).check(matches(isDisplayed()))
    }
}

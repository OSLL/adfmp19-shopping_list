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
class CreateListTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun findInExisting() {
        val newName = "новый список"
        check(!activityRule.activity.listMap.containsKey(newName))
        try {
            onView(withText(newName)).check(matches(not(isDisplayed())))
            check(false)
        } catch (e : NoMatchingViewException) {}

        onView(withId(R.id.CreateNew)).perform(click())
        onView(withId(R.id.enterListName)).perform(replaceText(newName))
        onView(withId(R.id.CreateNewList)).perform(click())

        check(activityRule.activity.listMap.containsKey(newName))
        onView(withText(newName)).check(matches(isDisplayed()))

    }
}

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
    fun oneNewListTest() {
        val newName = "New list"
        check(!activityRule.activity.dataHolder.getListsNames().contains(newName))
        try {
            onView(withText(newName)).check(matches(not(isDisplayed())))
            check(false)
        } catch (e : NoMatchingViewException) {}

        onView(withId(R.id.CreateNew)).perform(click())
        onView(withId(R.id.enterListName)).perform(replaceText(newName))
        onView(withId(R.id.CreateNewList)).perform(click())

        check(activityRule.activity.dataHolder.getListsNames().contains(newName))
        onView(withText(newName)).check(matches(isDisplayed()))
    }
    @Test
    fun threeRandomNewListsTest() {
        val n = 3
        for (i in 1..n) {
            val newName = getRandomName(6)
            check(!activityRule.activity.dataHolder.getListsNames().contains(newName))
            try {
                onView(withText(newName)).check(matches(not(isDisplayed())))
                check(false)
            } catch (e: NoMatchingViewException) {
            }

            onView(withId(R.id.CreateNew)).perform(click())
            onView(withId(R.id.enterListName)).perform(replaceText(newName))
            onView(withId(R.id.CreateNewList)).perform(click())

            check(activityRule.activity.dataHolder.getListsNames().contains(newName))
            onView(withText(newName)).check(matches(isDisplayed()))
        }
    }

    fun getRandomName(len : Int) : String {
        val charPool = arrayListOf('a', 'b', 'c', 'd')
        val name = (1..len)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");
        return name.get(0).toUpperCase() + name.substring(1)
    }
}

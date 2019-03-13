package com.example.company.myapplication

import android.widget.ArrayAdapter
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.popup.*
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class AddProductTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {
        val firstName = "первый список"
        val allOk = "ПОКА НИЧЕГО НЕ СЪЕЛИ"
        val productName = "молоко"
        val defaultUnit = "кг"
        val defaultQuantity = 0.5f

        onView(withText(firstName)).perform(click())
        onView(withId(R.id.addProduct)).perform(click())
        onView(withId(R.id.text_view_popup)).perform(replaceText(productName))
        onView(withId(R.id.button_popup)).perform(click())
        val product = ProductItem(productName, defaultUnit, defaultQuantity)
        onView(withText(product.toString())).check(matches(isDisplayed()))


    }
}

package com.example.company.myapplication

import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.EditText
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
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
@LargeTest
class AddProductTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addPredefinedProductTest() {
        val firstName = "первый список"
        val productName = "Milk"
        val defaultUnit = "кг"
        val defaultQuantity = 0.5f

        onView(withText(firstName)).perform(click())
        onView(withId(R.id.addProduct)).perform(click())
        onView(withId(R.id.text_view_popup)).perform(longClick())
        onView(withId(R.id.text_view_popup)).perform(pressKey(KeyEvent.KEYCODE_DEL))
        onView(withId(R.id.text_view_popup)).perform(typeText(productName))
        onView(withId(R.id.button_popup)).perform(click())
        val product = ProductItem(productName, defaultUnit, defaultQuantity)
        onView(withText(product.toString())).check(matches(isDisplayed()))
    }
}

package com.example.vinilosapp.ui.view


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vinilosapp.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CollectorListTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(CollectorList::class.java)

    @Test
    fun collectorListTest() {
        val textView = onView(
            allOf(
                withText("Vinilos App"),
                withParent(
                    allOf(
                        withId(R.id.my_toolbar),
                        withParent(withId(R.id.frameLayout))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Vinilos App")))

        val textView2 = onView(
            allOf(
                withId(R.id.tvName), withText("Manolo Bellon"),
                withParent(withParent(withId(R.id.recyclerCollector))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Manolo Bellon")))

        val textView3 = onView(
            allOf(
                withId(R.id.tvTelephone), withText("3502457896"),
                withParent(withParent(withId(R.id.recyclerCollector))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("3502457896")))

        val textView4 = onView(
            allOf(
                withId(R.id.tvEmail), withText("manollo@caracol.com.co"),
                withParent(withParent(withId(R.id.recyclerCollector))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("manollo@caracol.com.co")))
    }
}

package com.example.vinilosapp


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.vinilosapp.ui.view.AlbumDetail
import com.example.vinilosapp.ui.view.AlbumList
import com.example.vinilosapp.ui.view.CollectorDetail
import com.example.vinilosapp.ui.view.CollectorList
import com.example.vinilosapp.ui.view.adapter.AlbumViewholder
import com.example.vinilosapp.ui.view.adapter.CollectorViewholder
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CollectorListTest {

    @Before
    fun launchActivity() {
        // Launch the activity
        ActivityScenario.launch(CollectorList::class.java)
        Intents.init()
    }

    @Test
    fun clickRecyclerViewItem_opensSecondActivity() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        // Assuming you have at least one item in your RecyclerView
        onView(withId(R.id.recyclerCollector)).perform(
            RecyclerViewActions.actionOnItemAtPosition<CollectorViewholder>(
                0,
                click()
            )
        )

        // Verify that the second activity is launched
        Intents.intended(IntentMatchers.hasComponent(CollectorDetail::class.java.name))

    }

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

    @After
    fun after() {

        Intents.release()
    }

}

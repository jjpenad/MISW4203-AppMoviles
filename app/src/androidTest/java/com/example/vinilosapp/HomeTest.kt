package com.example.vinilosapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.vinilosapp.ui.view.AlbumDetail
import com.example.vinilosapp.ui.view.AlbumList
import com.example.vinilosapp.ui.view.HomeActivity
import com.example.vinilosapp.ui.view.adapter.AlbumViewholder
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeTest {


    @Before
    fun launchActivity() {
        // Launch the activity
        ActivityScenario.launch(HomeActivity::class.java)
        Intents.init()
    }

    @Test
    fun homeFields() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(R.id.appTitle)).check(ViewAssertions.matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.albumsBtn),
                withText("Albums")
            )
        ).check(ViewAssertions.matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.artistsBtn),
                withText("Artists")
            )
        ).check(ViewAssertions.matches(isDisplayed()))
    }
}
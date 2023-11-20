package com.example.vinilosapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.vinilosapp.ui.view.AlbumDetail
import com.example.vinilosapp.ui.view.AlbumList
import com.example.vinilosapp.ui.view.ArtistDetail
import com.example.vinilosapp.ui.view.ArtistList
import com.example.vinilosapp.ui.view.adapter.AlbumViewholder
import com.example.vinilosapp.ui.view.adapter.ArtistViewholder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistListTest {


    @Before
    fun launchActivity() {
        // Launch the activity
        ActivityScenario.launch(ArtistList::class.java)
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
        onView(withId(R.id.recyclerAlbum)).perform(
            actionOnItemAtPosition<ArtistViewholder>(
                0,
                click()
            )
        )

        // Verify that the second activity is launched
        intended(hasComponent(ArtistDetail::class.java.name))

    }
}
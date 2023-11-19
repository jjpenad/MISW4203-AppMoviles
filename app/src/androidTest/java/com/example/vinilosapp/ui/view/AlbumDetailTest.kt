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
class AlbumDetailTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AlbumDetail::class.java)

    @Test
    fun albumDetailTest() {
        val textView = onView(
            allOf(
                withId(R.id.tvAlbumTitle), withText("Buscando América"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Buscando América")))

        val textView2 = onView(
            allOf(
                withId(R.id.tvGenre), withText("Salsa"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Salsa")))

        val textView3 = onView(
            allOf(
                withId(R.id.tvAlbumDescription),
                withText("Buscando América es el primer álbum de la banda de Rubén Blades y Seis del Solar lanzado en 1984. La producción, bajo el sello Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, rock, y el jazz latino. El disco fue grabado en Eurosound Studios en Nueva York entre mayo y agosto de 1983."),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Buscando América es el primer álbum de la banda de Rubén Blades y Seis del Solar lanzado en 1984. La producción, bajo el sello Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, rock, y el jazz latino. El disco fue grabado en Eurosound Studios en Nueva York entre mayo y agosto de 1983.")))

        val imageView = onView(
            allOf(
                withId(R.id.ivAlbumCover),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))
    }
}

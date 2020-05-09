package com.example.marvelappiness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvelappiness.ui.main.MarvelActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.marvelappiness", appContext.packageName)
    }

    @Test
    fun test_Recycler() {
        val activityScenario = ActivityScenario.launch(MarvelActivity::class.java)
        onView(withId(R.id.recycler_marvel)).check(matches(isDisplayed()))
    }

    @Test
    fun test_Search() {
        val activityScenario = ActivityScenario.launch(MarvelActivity::class.java)
        onView(withId(R.id.action_search)).check(matches(isDisplayed()))
    }


}

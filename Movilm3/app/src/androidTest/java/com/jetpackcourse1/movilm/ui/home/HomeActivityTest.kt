package com.jetpackcourse1.movilm.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.ui.home.EspressoTestsMatchers.hasDrawable
import com.jetpackcourse1.movilm.ui.home.EspressoTestsMatchers.withDrawable
import com.jetpackcourse1.movilm.utils.DataDummy
import com.jetpackcourse1.movilm.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest{

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies(){
        delayTwoSecond()
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetail() {
        delayTwoSecond()
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click())
        )
        delayTwoSecond()
        onView(withId(R.id.img_poster)).check(matches(hasDrawable()))
        onView(withId(R.id.img_bg_poster)).check(matches(hasDrawable()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_score)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.img_add)).check(matches(hasDrawable()))
        onView(withId(R.id.img_rate)).check(matches(withDrawable(R.drawable.ic_thumb_up)))
        onView(withId(R.id.img_rate)).check(matches(hasDrawable()))
        onView(withId(R.id.img_share)).check(matches(withDrawable(R.drawable.ic_share)))
        onView(withId(R.id.img_share)).check(matches(hasDrawable()))
    }

    @Test
    fun loadTVShow(){
        onView(withText("TV Show")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFav(){
        onView(withId(R.id.bt_favorite)).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_favMovies)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_favTv)).check(matches(isDisplayed()))
    }

    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
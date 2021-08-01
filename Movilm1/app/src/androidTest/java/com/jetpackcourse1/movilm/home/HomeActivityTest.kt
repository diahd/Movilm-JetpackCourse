package com.jetpackcourse1.movilm.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.jetpackcourse1.movilm.R
import com.jetpackcourse1.movilm.home.EspressoTestsMatchers.hasDrawable
import com.jetpackcourse1.movilm.home.EspressoTestsMatchers.withDrawable
import com.jetpackcourse1.movilm.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTVShow = DataDummy.generateDummyTVShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetail() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click())
        )
        onView(withId(R.id.img_poster)).check(matches(hasDrawable()))
        onView(withId(R.id.img_bg_poster)).check(matches(hasDrawable()))
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.txt_score)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_score)).check(matches(withText(dummyMovie[0].score)))
        onView(withId(R.id.txt_date)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_date)).check(matches(withText(dummyMovie[0].date)))
        onView(withId(R.id.txt_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_rating)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.txt_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.txt_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.txt_creator)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_creator)).check(matches(withText("Creator/Director: ${dummyMovie[0].director}")))
        onView(withId(R.id.txt_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.img_add)).check(matches(withDrawable(R.drawable.ic_add)))
        onView(withId(R.id.img_add)).check(matches(hasDrawable()))
        onView(withId(R.id.img_rate)).check(matches(withDrawable(R.drawable.ic_thumb_up)))
        onView(withId(R.id.img_rate)).check(matches(hasDrawable()))
        onView(withId(R.id.img_share)).check(matches(withDrawable(R.drawable.ic_share)))
        onView(withId(R.id.img_share)).check(matches(hasDrawable()))
    }

    @Test
    fun loadTVShow(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))
    }
}
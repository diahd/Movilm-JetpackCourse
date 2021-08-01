package com.jetpackcourse1.movilm.home

import android.view.View
import org.hamcrest.Matcher

object EspressoTestsMatchers {
    fun withDrawable(resourceId: Int): DrawableMatcher {
        return DrawableMatcher(resourceId)
    }

    fun noDrawable(): Matcher<View> {
        return DrawableMatcher(DrawableMatcher.EMPTY)
    }

    fun hasDrawable(): Matcher<View> {
        return DrawableMatcher(DrawableMatcher.ANY)
    }
}
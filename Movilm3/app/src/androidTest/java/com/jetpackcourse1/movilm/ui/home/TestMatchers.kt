package com.jetpackcourse1.movilm.ui.home

import android.view.View
import org.hamcrest.Matcher

object EspressoTestsMatchers {
    fun withDrawable(resourceId: Int): DrawableMatcher {
        return DrawableMatcher(resourceId)
    }

    fun hasDrawable(): Matcher<View> {
        return DrawableMatcher(DrawableMatcher.ANY)
    }
}
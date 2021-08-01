package com.jetpackcourse1.movilm.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp(){
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShow() {
        val tvshowEntities = viewModel.getTVShow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities.size)
    }
}
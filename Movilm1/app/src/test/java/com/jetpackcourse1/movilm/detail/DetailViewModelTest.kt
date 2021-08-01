package com.jetpackcourse1.movilm.detail

import com.jetpackcourse1.movilm.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieTitle = dummyMovie.title

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelected(movieTitle)
    }

    @Test
    fun getFilm() {
        viewModel.setSelected(dummyMovie.title)
        val movieEntity = viewModel.getFilm()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.date, movieEntity.date)
        assertEquals(dummyMovie.score, movieEntity.score)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.director,movieEntity.director)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.duration, movieEntity.duration)
    }
}
package com.jetpackcourse1.movilm.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.utils.DataDummy
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        /*val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)*/
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<DataEntity>>()
        movies.value = dummyMovies

        `when`(dataRepository.getMovie()).thenReturn(movies)

        val movieEntities = viewModel.getMovies().value

        verify(dataRepository).getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}
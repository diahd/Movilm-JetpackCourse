package com.jetpackcourse1.movilm.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.utils.DataDummy
import com.jetpackcourse1.movilm.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id
    private val dummyTVShow = DataDummy.generateDummyTVShows()[0]
    private val tvId = dummyTVShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTV: Observer<Resource<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(dataRepository)
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieId?.let { dataRepository.getMovieDetail(it) }).thenReturn(movie)
        val movieEntity = movieId?.let { viewModel.getMovieDetail(it).value?.data }

        movieId?.let { verify(dataRepository).getMovieDetail(it) }
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.data?.id, movieEntity?.id)
        assertEquals(dummyMovie.data?.poster, movieEntity?.poster)
        assertEquals(dummyMovie.data?.title, movieEntity?.title)
        assertEquals(dummyMovie.data?.date, movieEntity?.date)
        assertEquals(dummyMovie.data?.score, movieEntity?.score)
        assertEquals(dummyMovie.data?.overview, movieEntity?.overview)

        movieId?.let { viewModel.getMovieDetail(it).observeForever(observerMovie) }
        verify(observerMovie).onChanged(dummyMovie)


    }

    @Test
    fun getTvDetail(){
        val dummyTVShow = Resource.success(DataDummy.generateDummyTVShows()[0])
        val tv = MutableLiveData<Resource<TVShowEntity>>()
        tv.value = dummyTVShow

        `when`(tvId?.let { dataRepository.getTVDetail(it) }).thenReturn(tv)
        val tvEntity = tvId?.let { viewModel.getTvDetail(it).value?.data }

        tvId?.let { verify(dataRepository).getTVDetail(it) }
        assertNotNull(tvEntity)
        assertEquals(dummyTVShow.data?.id, tvEntity?.id)
        assertEquals(dummyTVShow.data?.poster, tvEntity?.poster)
        assertEquals(dummyTVShow.data?.title, tvEntity?.title)
        assertEquals(dummyTVShow.data?.date, tvEntity?.date)
        assertEquals(dummyTVShow.data?.score, tvEntity?.score)
        assertEquals(dummyTVShow.data?.overview, tvEntity?.overview)

        tvId?.let { viewModel.getTvDetail(it).observeForever(observerTV) }
        verify(observerTV).onChanged(dummyTVShow)

    }
}
package com.jetpackcourse1.movilm.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.DataGenre
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
    private lateinit var observer: Observer<DataEntity>

    @Mock
    private lateinit var observerGenre : Observer<List<DataGenre>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(dataRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<DataEntity>()
        movie.value = dummyMovie

        `when`(dataRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovieDetail(movieId).value as DataEntity

        verify(dataRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.date, movieEntity.date)
        assertEquals(dummyMovie.score, movieEntity.score)
        assertEquals(dummyMovie.overview, movieEntity.overview)

        viewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovie)


    }

    @Test
    fun getTvDetail(){
        val tv = MutableLiveData<DataEntity>()
        tv.value = dummyTVShow

        `when`(dataRepository.getTVDetail(tvId)).thenReturn(tv)
        val tvEntity = viewModel.getTvDetail(tvId).value as DataEntity

        verify(dataRepository).getTVDetail(tvId)
        assertNotNull(tvEntity)
        assertEquals(dummyTVShow.id, tvEntity.id)
        assertEquals(dummyTVShow.poster, tvEntity.poster)
        assertEquals(dummyTVShow.title, tvEntity.title)
        assertEquals(dummyTVShow.date, tvEntity.date)
        assertEquals(dummyTVShow.score, tvEntity.score)
        assertEquals(dummyTVShow.overview, tvEntity.overview)

        viewModel.getTvDetail(tvId).observeForever(observer)
        verify(observer).onChanged(dummyTVShow)

    }

    @Test
    fun getMovieGenre(){
        val dummyGenreMovie = DataDummy.generateDummyMovieGenre()
        val genreMovie = MutableLiveData<List<DataGenre>>()
        genreMovie.value = dummyGenreMovie

        `when`(dataRepository.getMovieGenre(movieId)).thenReturn(genreMovie)

        val genreEntities = viewModel.getMovieGenre(movieId).value

        verify(dataRepository).getMovieGenre(movieId)
        assertNotNull(genreEntities)

        viewModel.getMovieGenre(movieId).observeForever(observerGenre)
        verify(observerGenre).onChanged(dummyGenreMovie)

    }

    @Test
    fun getTVGenre(){
        val dummyGenreTv = DataDummy.generateDummyTVGenre()
        val genreTv = MutableLiveData<List<DataGenre>>()
        genreTv.value = dummyGenreTv

        `when`(dataRepository.getTVGenre(tvId)).thenReturn(genreTv)

        val genreEntities = viewModel.getTVGenre(tvId).value

        verify(dataRepository).getTVGenre(tvId)
        assertNotNull(genreEntities)

        viewModel.getTVGenre(tvId).observeForever(observerGenre)
        verify(observerGenre).onChanged(dummyGenreTv)

    }
}
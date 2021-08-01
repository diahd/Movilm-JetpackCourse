package com.jetpackcourse1.movilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jetpackcourse1.movilm.data.source.local.LocalDataSource
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource
import com.jetpackcourse1.movilm.utils.AppExecutors
import com.jetpackcourse1.movilm.utils.DataDummy
import com.jetpackcourse1.movilm.utils.LiveDataTestUtil
import com.jetpackcourse1.movilm.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DataRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val dataRepository = FakeDataRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movieResponsesDetail = DataDummy.generateDummyMovies()[0]
    private val movieId = movieResponses[0].id
    private val tvshowResponses = DataDummy.generateDummyTVShows()
    private val tvshowResponsesDetail = DataDummy.generateDummyTVShows()[0]
    private val tvshowId = tvshowResponses[0].id

    @Test
    fun getMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        dataRepository.getMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movieResponsesDetail
        `when`(movieId?.let { local.getDetailMovies(it) }).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(dataRepository.getMovieDetail(movieId!!))
        verify(local).getDetailMovies(movieId)
        assertNotNull(movieEntity)
        assertEquals(movieResponsesDetail.id, movieEntity.data?.id)

    }

    @Test
    fun getTV(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getAllTV()).thenReturn(dataSourceFactory)
        dataRepository.getTV()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(tvshowResponses))
        verify(local).getAllTV()
        assertNotNull(tvEntities.data)
        assertEquals(tvshowResponses.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getTvDetail() {
        val dummyTV = MutableLiveData<TVShowEntity>()
        dummyTV.value = tvshowResponsesDetail
        `when`(tvshowId?.let { local.getDetailTVs(it) }).thenReturn(dummyTV)

        val tvEntity = LiveDataTestUtil.getValue(dataRepository.getTVDetail(tvshowId!!))
        verify(local).getDetailTVs(tvshowId)
        assertNotNull(tvEntity)
        assertEquals(tvshowResponsesDetail.id, tvEntity.data?.id)
    }

    fun getListFavMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getListFavMovies()).thenReturn(dataSourceFactory)
        dataRepository.getListFavMovie()

        val movieFavEntities = Resource.success(PagedListUtil.mockPagedList(movieResponses))
        verify(local).getListFavMovies()
        assertNotNull(movieFavEntities)
        assertEquals(movieResponses.size.toLong(), movieFavEntities.data?.size?.toLong())
    }

    fun getListFavTV() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getListFavTVs()).thenReturn(dataSourceFactory)
        dataRepository.getListFavTV()

        val tvFavEntities = Resource.success(PagedListUtil.mockPagedList(tvshowResponses))
        verify(local).getListFavTVs()
        assertNotNull(tvFavEntities)
        assertEquals(tvshowResponses.size.toLong(), tvFavEntities.data?.size?.toLong())
    }
}
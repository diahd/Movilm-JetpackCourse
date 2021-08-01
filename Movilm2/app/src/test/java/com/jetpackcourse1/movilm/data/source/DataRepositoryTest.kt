package com.jetpackcourse1.movilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource
import com.jetpackcourse1.movilm.utils.DataDummy
import com.jetpackcourse1.movilm.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DataRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val dataRepository = FakeDataRepository(remote)

    private val movieResponses = DataDummy.generateDummyMoviesRemote()
    private val movieResponsesDetail = DataDummy.generateDummyMoviesRemote()[0]
    private val movieResponsesGenre = DataDummy.generateDummyMovieGenreRemote()
    private val movieId = movieResponses[0].id
    private val tvshowResponses = DataDummy.generateDummyTVShowsRemote()
    private val tvshowResponsesDetail = DataDummy.generateDummyTVShowsRemote()[0]
    private val tvshowResponsesGenre = DataDummy.generateDummyTVGenreRemote()
    private val tvshowId = tvshowResponses[0].id

    @Test
    fun getMovie(){
        runBlocking {
            doAnswer{ invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                        .onAllMovieReceived(movieResponses)
                null
            }.`when`(remote).getMovie(any())
        }

        val movieEntities = LiveDataTestUtil.getValue(dataRepository.getMovie())
        runBlocking { verify(remote).getMovie(any()) }
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer{ invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback)
                        .onMovieReceived(movieResponsesDetail)
                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val movieDetail = LiveDataTestUtil.getValue(dataRepository.getMovieDetail(movieId))
        runBlocking { verify(remote).getMovieDetail(eq(movieId), any()) }
        assertNotNull(movieDetail)
        assertEquals(movieResponsesDetail.id, movieDetail.id)
    }

    @Test
    fun getMovieGenre(){
        runBlocking {
            doAnswer{ invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieGenreCallback)
                        .onMovieGenreReceived(movieResponsesGenre)
                null
            }.`when`(remote).getMovieGenre(eq(movieId), any())
        }

        val movieGenre = LiveDataTestUtil.getValue(dataRepository.getMovieGenre(movieId))
        runBlocking { verify(remote).getMovieGenre(eq(movieId), any()) }
        assertNotNull(movieGenre)
        assertEquals(movieResponsesGenre.size.toLong(), movieGenre.size.toLong())
    }

    @Test
    fun getTV(){
        runBlocking {
            doAnswer{ invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTVCallback)
                        .onAllTVReceived(tvshowResponses)
                null
            }.`when`(remote).getTV(any())
        }

        val tvEntities = LiveDataTestUtil.getValue(dataRepository.getTV())
        runBlocking { verify(remote).getTV(any()) }
        assertNotNull(tvEntities)
        assertEquals(tvshowResponses.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getTvDetail() {
        runBlocking {
            doAnswer{ invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTVDetailCallback)
                        .onTVReceived(tvshowResponsesDetail)
                null
            }.`when`(remote).getTVDetail(eq(tvshowId), any())
        }

        val tvDetail = LiveDataTestUtil.getValue(dataRepository.getTVDetail(tvshowId))
        runBlocking { verify(remote).getTVDetail(eq(tvshowId), any()) }
        assertNotNull(tvDetail)
        assertEquals(tvshowResponsesDetail.id, tvDetail.id)
    }

    @Test
    fun getTvGenre(){
        runBlocking { doAnswer{ invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadTVGenreCallback)
                    .onTVGenreReceived(tvshowResponsesGenre)
            null
        }.`when`(remote).getTVGenre(eq(tvshowId), any()) }

        val tvGenre = LiveDataTestUtil.getValue(dataRepository.getTVGenre(tvshowId))
        runBlocking { verify(remote).getTVGenre(eq(tvshowId), any()) }
        assertNotNull(tvGenre)
        assertEquals(tvshowResponsesGenre.size.toLong(), tvGenre.size.toLong())
    }


}
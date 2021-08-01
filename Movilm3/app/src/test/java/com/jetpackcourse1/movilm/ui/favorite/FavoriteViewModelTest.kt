package com.jetpackcourse1.movilm.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
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
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTV: Observer<PagedList<TVShowEntity>>

    @Before
    fun setUp(){
        viewModel = FavoriteViewModel(dataRepository)
    }

    @Test
    fun `getFavMovie should be success`() {
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = PagedTestDataSources.snapshot(DataDummy.generateDummyMovies())

        `when`(dataRepository.getListFavMovie()).thenReturn(expected)

        viewModel.getFavMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavMovie().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavMovie should be access but data is empty`() {
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(dataRepository.getListFavMovie()).thenReturn(expected)

        viewModel.getFavMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavMovie().value?.size
        assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    @Test
    fun `getFavTV should be success`() {
        val expected = MutableLiveData<PagedList<TVShowEntity>>()
        expected.value = PagedTestDataSourcesTV.snapshot2(DataDummy.generateDummyTVShows())

        `when`(dataRepository.getListFavTV()).thenReturn(expected)

        viewModel.getFavTV().observeForever(observerTV)
        verify(observerTV).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavTV().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavTV should be access but data is empty`() {
        val expected = MutableLiveData<PagedList<TVShowEntity>>()
        expected.value = PagedTestDataSourcesTV.snapshot2()

        `when`(dataRepository.getListFavTV()).thenReturn(expected)

        viewModel.getFavTV().observeForever(observerTV)
        verify(observerTV).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavTV().value?.size
        assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    class PagedTestDataSources private constructor(private val items: List<MovieEntity>) : PositionalDataSource<MovieEntity>() {
        companion object {
            fun snapshot(items: List<MovieEntity> = listOf()): PagedList<MovieEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<MovieEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MovieEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }

    class PagedTestDataSourcesTV private constructor(private val items: List<TVShowEntity>) : PositionalDataSource<TVShowEntity>() {
        companion object {
            fun snapshot2(items: List<TVShowEntity> = listOf()): PagedList<TVShowEntity> {
                return PagedList.Builder(PagedTestDataSourcesTV(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<TVShowEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TVShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}
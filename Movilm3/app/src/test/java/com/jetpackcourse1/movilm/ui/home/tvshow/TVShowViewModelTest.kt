package com.jetpackcourse1.movilm.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
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
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TVShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowEntity>

    @Before
    fun setUp(){
        viewModel = TVShowViewModel(dataRepository)
    }

    @Test
    fun getTv() {
        val dummyTVShow = Resource.success(pagedList)
        `when`(dummyTVShow.data?.size).thenReturn(20)
        val tvshows = MutableLiveData<Resource<PagedList<TVShowEntity>>>()
        tvshows.value = dummyTVShow

        `when`(dataRepository.getTV()).thenReturn(tvshows)

        val tvShowEntities = viewModel.getTv().value?.data

        verify(dataRepository).getTV()
        assertNotNull(tvShowEntities)
        assertEquals(20, tvShowEntities?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}
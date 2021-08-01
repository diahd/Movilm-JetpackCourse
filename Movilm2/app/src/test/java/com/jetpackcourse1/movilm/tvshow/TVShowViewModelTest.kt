package com.jetpackcourse1.movilm.tvshow

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
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>


    @Before
    fun setUp(){
        viewModel = TVShowViewModel(dataRepository)
    }

    @Test
    fun getTv() {
        /*val tvshowEntities = viewModel.getTVShow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities.size)*/
        val dummyTVShow = DataDummy.generateDummyTVShows()
        val tvshows = MutableLiveData<List<DataEntity>>()
        tvshows.value = dummyTVShow

        `when`(dataRepository.getTV()).thenReturn(tvshows)

        val tvShowEntities = viewModel.getTv().value
        verify(dataRepository).getTV()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}
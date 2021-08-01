package com.jetpackcourse1.movilm.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.vo.Resource

class TVShowViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getTv() : LiveData<Resource<PagedList<TVShowEntity>>> = dataRepository.getTV()
}
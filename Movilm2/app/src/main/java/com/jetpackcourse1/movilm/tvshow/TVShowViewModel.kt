package com.jetpackcourse1.movilm.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.source.DataRepository

class TVShowViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getTv() : LiveData<List<DataEntity>> = dataRepository.getTV()
}
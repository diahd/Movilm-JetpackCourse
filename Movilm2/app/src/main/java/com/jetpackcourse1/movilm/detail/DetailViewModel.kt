package com.jetpackcourse1.movilm.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.DataGenre
import com.jetpackcourse1.movilm.data.source.DataRepository

class DetailViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun getMovieDetail(id : Int) : LiveData<DataEntity> = dataRepository.getMovieDetail(id)

    fun getTvDetail(id: Int) : LiveData<DataEntity> = dataRepository.getTVDetail(id)

    fun getMovieGenre(id: Int) : LiveData<List<DataGenre>> = dataRepository.getMovieGenre(id)

    fun getTVGenre(id: Int) : LiveData<List<DataGenre>> = dataRepository.getTVGenre(id)

}
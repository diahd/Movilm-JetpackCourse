package com.jetpackcourse1.movilm.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.source.DataRepository

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getMovies() : LiveData<List<DataEntity>> = dataRepository.getMovie()
}
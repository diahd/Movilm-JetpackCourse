package com.jetpackcourse1.movilm.movie

import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = DataDummy.generateDummyMovies()
}
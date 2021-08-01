package com.jetpackcourse1.movilm.data.source

import androidx.lifecycle.LiveData
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.DataGenre

interface DataSource {

    fun getMovie(): LiveData<List<DataEntity>>

    fun getMovieDetail(id : Int) : LiveData<DataEntity>

    fun getMovieGenre(Id: Int) : LiveData<List<DataGenre>>

    fun getTV(): LiveData<List<DataEntity>>

    fun getTVDetail(id : Int) : LiveData<DataEntity>

    fun getTVGenre(Id: Int) : LiveData<List<DataGenre>>

}
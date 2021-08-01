package com.jetpackcourse1.movilm.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.vo.Resource

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun getMovies() : LiveData<Resource<PagedList<MovieEntity>>> = dataRepository.getMovie()
}
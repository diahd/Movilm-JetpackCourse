package com.jetpackcourse1.movilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.vo.Resource

class DetailViewModel(private val dataRepository: DataRepository): ViewModel() {

    fun getMovieDetail(id : Int) : LiveData<Resource<MovieEntity>> = dataRepository.getMovieDetail(id)

    fun getTvDetail(id: Int) : LiveData<Resource<TVShowEntity>> = dataRepository.getTVDetail(id)

    fun setFavMovie(movie: MovieEntity, state: Boolean) = dataRepository.setFavMovie(movie, state)

    fun setFavTV(tv: TVShowEntity, state: Boolean) = dataRepository.setFavTV(tv, state)
}
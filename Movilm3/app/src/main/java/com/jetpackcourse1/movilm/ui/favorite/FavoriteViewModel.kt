package com.jetpackcourse1.movilm.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity

class FavoriteViewModel(private val dataRepository: DataRepository) : ViewModel()  {

    fun getFavMovie(): LiveData<PagedList<MovieEntity>> = dataRepository.getListFavMovie()

    fun getFavTV(): LiveData<PagedList<TVShowEntity>> = dataRepository.getListFavTV()

    fun setFavMovie(movieEntity: MovieEntity, newState: Boolean) {
        dataRepository.setFavMovie(movieEntity, newState)
    }

    fun setFavTV(tvEntity: TVShowEntity, newState: Boolean) {
        dataRepository.setFavTV(tvEntity, newState)
    }
}
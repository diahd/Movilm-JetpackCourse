package com.jetpackcourse1.movilm.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.vo.Resource

interface DataSource {

    //movie
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(id : Int) : LiveData<Resource<MovieEntity>>

    fun getListFavMovie(): LiveData<PagedList<MovieEntity>>

    fun setFavMovie(movie: MovieEntity, state: Boolean)

    //TV
    fun getTV(): LiveData<Resource<PagedList<TVShowEntity>>>

    fun getTVDetail(id : Int) : LiveData<Resource<TVShowEntity>>

    fun getListFavTV(): LiveData<PagedList<TVShowEntity>>

    fun setFavTV(tv: TVShowEntity, state: Boolean)

}
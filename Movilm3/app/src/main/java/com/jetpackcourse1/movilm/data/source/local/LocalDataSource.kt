package com.jetpackcourse1.movilm.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.jetpackcourse1.movilm.data.source.local.entity.*
import com.jetpackcourse1.movilm.data.source.local.room.DataDAO

class LocalDataSource private constructor(private val mDataDao: DataDAO) {

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dataDao: DataDAO): LocalDataSource =
                INSTANCE?: LocalDataSource(dataDao)
    }

    //movie
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mDataDao.getMovie()

    fun getListFavMovies() : DataSource.Factory<Int, MovieEntity> = mDataDao.getListFavMovie()

    fun getDetailMovies(movieId: Int) : LiveData<MovieEntity> = mDataDao.getDetailMovie(movieId)

    fun insertMovies(movies: List<MovieEntity>) = mDataDao.insertMovie(movies)

    fun insertMovieDetail(movie: MovieEntity) = mDataDao.insertMovieDetail(movie)

    fun setFavMovie(movie : MovieEntity, state: Boolean){
        movie.isFavorite = !state
        mDataDao.updateMovie(movie)
    }

    //tv
    fun getAllTV(): DataSource.Factory<Int, TVShowEntity> = mDataDao.getTV()

    fun getListFavTVs(): DataSource.Factory<Int, TVShowEntity> = mDataDao.getListFavTV()

    fun getDetailTVs(tvId: Int) : LiveData<TVShowEntity> = mDataDao.getDetailTV(tvId)

    fun insertTV(tvs: List<TVShowEntity>) = mDataDao.insertTV(tvs)

    fun insertTVDetail(tv: TVShowEntity) = mDataDao.insertTVDetail(tv)

    fun setFavTV(tv : TVShowEntity, state: Boolean) {
        tv.isFavorite = !state
        mDataDao.updateTV(tv)
    }
}
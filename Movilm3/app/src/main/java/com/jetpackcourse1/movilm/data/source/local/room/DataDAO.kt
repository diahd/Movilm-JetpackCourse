package com.jetpackcourse1.movilm.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.jetpackcourse1.movilm.data.source.local.entity.*

@Dao
interface DataDAO {
    //Movie
    @Query("SELECT * FROM movieentity")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentity WHERE isFavorite = 1")
    fun getListFavMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentity WHERE id = :movieId")
    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity>

    //TV
    @Query("SELECT * FROM tvshowentity")
    fun getTV(): DataSource.Factory<Int, TVShowEntity>
    //LiveData<List<TVShowEntity>>

    @Query("SELECT * FROM tvshowentity WHERE isFavorite = 1")
    fun getListFavTV(): DataSource.Factory<Int, TVShowEntity>
    //LiveData<List<TVShowEntity>>

    @Query("SELECT * FROM tvshowentity WHERE id = :tvId")
    fun getDetailTV(tvId: Int) : LiveData<TVShowEntity>

    //Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovie(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovieDetail(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TVShowEntity::class)
    fun insertTV(tv: List<TVShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TVShowEntity::class)
    fun insertTVDetail(tv: TVShowEntity)

    //Update
    @Update(entity = MovieEntity::class)
    fun updateMovie(movie: MovieEntity)

    @Update(entity = TVShowEntity::class)
    fun updateTV(tv: TVShowEntity)
}
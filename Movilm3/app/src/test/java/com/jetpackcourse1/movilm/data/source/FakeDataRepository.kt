package com.jetpackcourse1.movilm.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jetpackcourse1.movilm.data.source.local.LocalDataSource
import com.jetpackcourse1.movilm.data.source.local.entity.MovieEntity
import com.jetpackcourse1.movilm.data.source.local.entity.TVShowEntity
import com.jetpackcourse1.movilm.data.source.remote.ApiResponse
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItem
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItemTV
import com.jetpackcourse1.movilm.utils.AppExecutors
import com.jetpackcourse1.movilm.vo.Resource

class FakeDataRepository constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
        ): DataSource {

    override fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItem>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getMovie()

            public override fun saveCallResult(data: List<ResultsItem>) {
                val movieList = ArrayList<MovieEntity>()
                for(item in data){
                    val movies = MovieEntity(
                        null,
                        item.posterPath,
                        item.id,
                        item.title,
                        item.releaseDate,
                        item.voteAverage.toString(),
                        item.overview,
                        false
                    )
                    movieList.add(movies)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(id: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, ResultsItem>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> =
                    localDataSource.getDetailMovies(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null

            public override fun createCall(): LiveData<ApiResponse<ResultsItem>> =
                    remoteDataSource.getMovieDetail(id)

            override fun saveCallResult(data: ResultsItem) {
                val movie = MovieEntity(
                        null,
                        data.posterPath,
                        data.id,
                        data.title,
                        data.releaseDate,
                        data.voteAverage.toString(),
                        data.overview,
                        false
                )
                localDataSource.insertMovieDetail(movie)
            }
        }.asLiveData()
    }

    override fun getTV(): LiveData<Resource<PagedList<TVShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TVShowEntity>, List<ResultsItemTV>>(appExecutors){
            public override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTV(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsItemTV>>> =
                remoteDataSource.getTV()

            public override fun saveCallResult(data: List<ResultsItemTV>) {
                val tvList = ArrayList<TVShowEntity>()
                for(item in data){
                    val tvs = TVShowEntity(
                        null,
                        item.posterPath,
                        item.id,
                        item.originalName,
                        item.firstAirDate,
                        item.voteAverage.toString(),
                        item.overview,
                        false
                    )
                    tvList.add(tvs)
                }
                localDataSource.insertTV(tvList)
            }
        }.asLiveData()
    }

    override fun getTVDetail(id: Int): LiveData<Resource<TVShowEntity>> {
        return object : NetworkBoundResource<TVShowEntity, ResultsItemTV>(appExecutors){
            override fun loadFromDB(): LiveData<TVShowEntity> =
                    localDataSource.getDetailTVs(id)

            override fun shouldFetch(data: TVShowEntity?): Boolean =
                    data == null

            public override fun createCall(): LiveData<ApiResponse<ResultsItemTV>> =
                    remoteDataSource.getTVDetail(id)

            override fun saveCallResult(data: ResultsItemTV) {
                val tv = TVShowEntity(
                        null,
                        data.posterPath,
                        data.id,
                        data.originalName,
                        data.firstAirDate,
                        data.voteAverage.toString(),
                        data.overview,
                        false
                )
                localDataSource.insertTVDetail(tv)
            }
        }.asLiveData()
    }

    override fun getListFavMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavMovies(), config).build()
    }

    override fun setFavMovie(movie: MovieEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setFavMovie(movie, state) }

    override fun getListFavTV(): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavTVs(), config).build()
    }

    override fun setFavTV(tv: TVShowEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setFavTV(tv, state) }
}
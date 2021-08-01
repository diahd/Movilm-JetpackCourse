package com.jetpackcourse1.movilm.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.data.DataGenre
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource
import com.jetpackcourse1.movilm.data.source.remote.response.GenresItemMovie
import com.jetpackcourse1.movilm.data.source.remote.response.GenresItemTV
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItem
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItemTV
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeDataRepository(private val remoteDataSource: RemoteDataSource): DataSource {

    override fun getMovie(): LiveData<List<DataEntity>> {
        val movieResults = MutableLiveData<List<DataEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovie(object : RemoteDataSource.LoadMovieCallback {
                override fun onAllMovieReceived(resultsItem: List<ResultsItem>) {
                    val movieList = ArrayList<DataEntity>()
                    for(item in resultsItem){
                        val movies = DataEntity(
                                item.posterPath,
                                item.id,
                                item.title,
                                item.releaseDate,
                                //null,
                                item.voteAverage.toString(),
                                item.overview
                        )
                        movieList.add(movies)
                    }
                    movieResults.postValue(movieList)
                }
            })
        }
        return  movieResults
    }

    override fun getMovieDetail(id: Int): LiveData<DataEntity> {
        val movieResult = MutableLiveData<DataEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieDetail(id, object : RemoteDataSource.LoadMovieDetailCallback {
                override fun onMovieReceived(resultsItem: ResultsItem) {
                    val movie = DataEntity(
                            resultsItem.posterPath,
                            resultsItem.id,
                            resultsItem.title,
                            resultsItem.releaseDate,
                            //resultsItem.runtime.toString(),
                            resultsItem.voteAverage.toString(),
                            resultsItem.overview
                    )
                    movieResult.postValue(movie)
                }
            })
        }
        return movieResult
    }

    override fun getMovieGenre(Id: Int): LiveData<List<DataGenre>> {
        val movieGenre = MutableLiveData<List<DataGenre>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieGenre(Id, object : RemoteDataSource.LoadMovieGenreCallback {
                override fun onMovieGenreReceived(resultsItem: List<GenresItemMovie>) {
                    val genreList = ArrayList<DataGenre>()
                    for(item in resultsItem){
                        val genM = DataGenre(
                                item.name,
                                item.id
                        )
                        genreList.add(genM)
                    }
                    movieGenre.postValue(genreList)
                }
            })
        }
        return movieGenre
    }

    override fun getTV(): LiveData<List<DataEntity>> {
        val tvResults = MutableLiveData<List<DataEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTV(object : RemoteDataSource.LoadTVCallback{
                override fun onAllTVReceived(resultItemTV: List<ResultsItemTV>) {
                    val tvList = ArrayList<DataEntity>()
                    for(item in resultItemTV){
                        val tvs = DataEntity(
                                item.posterPath,
                                item.id,
                                item.originalName,
                                item.firstAirDate,
                                //null,
                                //item.episodeRunTime.get(0).toString(),
                                item.voteAverage.toString(),
                                item.overview
                        )
                        tvList.add(tvs)
                    }
                    tvResults.postValue(tvList)
                }
            })
        }
        return  tvResults
    }

    override fun getTVDetail(id: Int): LiveData<DataEntity> {
        val tvResult = MutableLiveData<DataEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTVDetail(id, object : RemoteDataSource.LoadTVDetailCallback {
                override fun onTVReceived(resultsItem: ResultsItemTV) {
                    val tv = DataEntity(
                            resultsItem.posterPath,
                            resultsItem.id,
                            resultsItem.originalName,
                            resultsItem.firstAirDate,
                            //null,
                            resultsItem.voteAverage.toString(),
                            resultsItem.overview
                    )
                    tvResult.postValue(tv)
                }
            })
        }
        return tvResult
    }

    override fun getTVGenre(Id: Int): LiveData<List<DataGenre>> {
        val tvGenre = MutableLiveData<List<DataGenre>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTVGenre(Id, object : RemoteDataSource.LoadTVGenreCallback {
                override fun onTVGenreReceived(resultsItem: List<GenresItemTV>) {
                    val genreList = ArrayList<DataGenre>()
                    for(item in resultsItem){
                        val genTV = DataGenre(
                                item.name,
                                item.id
                        )
                        genreList.add(genTV)
                    }
                    tvGenre.postValue(genreList)
                }
            })
        }
        return tvGenre
    }

}
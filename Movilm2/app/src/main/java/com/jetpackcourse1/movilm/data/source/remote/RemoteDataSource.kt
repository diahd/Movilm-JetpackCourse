package com.jetpackcourse1.movilm.data.source.remote

import com.jetpackcourse1.movilm.data.source.remote.api.ApiConfig
import com.jetpackcourse1.movilm.data.source.remote.response.*
import com.jetpackcourse1.movilm.utils.EspressoIdlingResource
import retrofit2.await
class RemoteDataSource {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this){
                    instance ?: RemoteDataSource().apply { instance = this}
                }
    }

    suspend fun getMovie(callback: LoadMovieCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovie().await().results.let {
            callback.onAllMovieReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(Id: Int, callback: LoadMovieDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieDetail(Id).await().let {
            callback.onMovieReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieGenre(Id: Int, callback: LoadMovieGenreCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieDetail(Id).await().genres.let {
            callback.onMovieGenreReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTV(callback: LoadTVCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTV().await().resultsTV.let {
            callback.onAllTVReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTVDetail(Id: Int, callback: LoadTVDetailCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTVDetail(Id).await().let {
            callback.onTVReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTVGenre(Id: Int, callback: LoadTVGenreCallback){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTVDetail(Id).await().genres.let {
            callback.onTVGenreReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(resultsItem: List<ResultsItem>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieReceived(resultsItem: ResultsItem)
    }

    interface LoadMovieGenreCallback {
        fun onMovieGenreReceived(resultsItem: List<GenresItemMovie>)
    }

    interface LoadTVCallback {
        fun onAllTVReceived(resultItemTV: List<ResultsItemTV>)
    }

    interface LoadTVDetailCallback {
        fun onTVReceived(resultsItem: ResultsItemTV)
    }

    interface LoadTVGenreCallback {
        fun onTVGenreReceived(resultsItem: List<GenresItemTV>)
    }
}
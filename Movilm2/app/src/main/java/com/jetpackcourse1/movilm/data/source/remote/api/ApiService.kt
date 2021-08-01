package com.jetpackcourse1.movilm.data.source.remote.api

import com.jetpackcourse1.movilm.BuildConfig
import com.jetpackcourse1.movilm.data.source.remote.response.ResponseMovie
import com.jetpackcourse1.movilm.data.source.remote.response.ResponseTV
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItem
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItemTV
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/upcoming")
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ResponseMovie>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ResultsItem>

    @GET("tv/on_the_air")
    fun getTV(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ResponseTV>

    @GET("tv/{id}")
    fun getTVDetail(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ResultsItemTV>
}
package com.jetpackcourse1.movilm.data.source.remote.api

import com.jetpackcourse1.movilm.BuildConfig
import com.jetpackcourse1.movilm.data.source.remote.response.ResponseMovie
import com.jetpackcourse1.movilm.data.source.remote.response.ResponseTV
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItem
import com.jetpackcourse1.movilm.data.source.remote.response.ResultsItemTV
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    companion object{
        fun getApiService(): ApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
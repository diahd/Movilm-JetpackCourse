package com.jetpackcourse1.movilm.di

import android.content.Context
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.local.LocalDataSource
import com.jetpackcourse1.movilm.data.source.local.room.DatabaseDAO
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource
import com.jetpackcourse1.movilm.data.source.remote.api.ApiService
import com.jetpackcourse1.movilm.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context) : DataRepository{

        val database = DatabaseDAO.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiService.getApiService())

        val localDataSource = LocalDataSource.getInstance(database.dataDao())

        val appExecutors = AppExecutors()

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
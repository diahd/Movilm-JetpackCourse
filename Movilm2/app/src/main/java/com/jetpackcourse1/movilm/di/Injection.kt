package com.jetpackcourse1.movilm.di

import android.content.Context
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context) : DataRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return DataRepository.getInstance(remoteDataSource)
    }
}
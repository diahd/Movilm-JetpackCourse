package com.jetpackcourse1.movilm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetpackcourse1.movilm.data.source.DataRepository
import com.jetpackcourse1.movilm.detail.DetailViewModel
import com.jetpackcourse1.movilm.di.Injection
import com.jetpackcourse1.movilm.movie.MovieViewModel
import com.jetpackcourse1.movilm.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val mDataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this){
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mDataRepository) as T
            }

            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(mDataRepository) as T
            }

            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mDataRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
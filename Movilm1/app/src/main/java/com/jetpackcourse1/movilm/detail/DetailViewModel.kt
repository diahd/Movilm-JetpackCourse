package com.jetpackcourse1.movilm.detail

import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var title: String

    fun setSelected(title: String) {
        this.title = title
    }

    fun getFilm(): DataEntity {
        lateinit var data: DataEntity
        val movieEntities = DataDummy.generateDummyMovies()
        val tvshowEntities = DataDummy.generateDummyTVShows()
        for (movieEntity in movieEntities) {
            if (movieEntity.title == title) {
                data = movieEntity
                continue
            }
        }
        for(tvshowEntity in tvshowEntities){
            if(tvshowEntity.title == title){
                data = tvshowEntity
            }
        }
        return data
    }
}
package com.jetpackcourse1.movilm.tvshow

import androidx.lifecycle.ViewModel
import com.jetpackcourse1.movilm.data.DataEntity
import com.jetpackcourse1.movilm.utils.DataDummy

class TVShowViewModel : ViewModel() {
    fun getTVShow(): List<DataEntity> = DataDummy.generateDummyTVShows()
}
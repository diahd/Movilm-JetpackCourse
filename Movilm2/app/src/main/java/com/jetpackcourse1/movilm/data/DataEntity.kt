package com.jetpackcourse1.movilm.data

data class DataEntity(
        var poster: String?,
        var id: Int,
        var title: String?,
        var date: String?,
        var score: String?,
        var overview: String
)

data class DataGenre(
        var name: String?,
        var id: Int?
)
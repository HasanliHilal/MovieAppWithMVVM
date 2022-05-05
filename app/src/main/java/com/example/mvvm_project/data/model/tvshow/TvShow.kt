package com.example.mvvm_project.data.model.tvshow


import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "popular_tvshows")
data class TvShow(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
)
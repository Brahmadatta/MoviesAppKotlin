package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class MovieModel(

    @SerializedName("id")
    val id : String,
    @SerializedName("url")
    val url : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("season")
    val season : String,
    @SerializedName("number")
    val number : String,
    @SerializedName("airdate")
    val airdate : String,
    @SerializedName("airtime")
    val airtime : String,
    @SerializedName("airstamp")
    val airstamp : String,
    @SerializedName("runtime")
    val runtime : String,
    @SerializedName("summary")
    val summary : String,
    @SerializedName("show")
    val show : Show,
    @SerializedName("_links")
    val links : Links

)

data class Links (
    @SerializedName("self")
    val self : Self
)

data class Self(
    @SerializedName("href")
    val href : String
)

data class Show (

    @SerializedName("id")
    val id : String,
    @SerializedName("url")
    val url : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("type")
    val type : String,
    @SerializedName("language")
    val language : String,
    @SerializedName("status")
    val status : String,
    @SerializedName("premiered")
    val premiered : String,
    @SerializedName("image")
    val image : ImageData,
    @SerializedName("summary")
    val summary : String,

    )

data class ImageData(
    @SerializedName("medium")
    val medium : String,
    @SerializedName("original")
    val original : String
)



package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieModel(

    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("season")
    val season: String?,
    @SerializedName("number")
    val number: String?,
    @SerializedName("airdate")
    val airdate: String?,
    @SerializedName("airtime")
    val airtime: String?,
    @SerializedName("airstamp")
    val airstamp: String?,
    @SerializedName("runtime")
    val runtime: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("show")
    val show: Show?,
    @SerializedName("_links")
    val links: Links

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Show::class.java.classLoader),
        TODO("links")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(url)
        parcel.writeString(name)
        parcel.writeString(season)
        parcel.writeString(number)
        parcel.writeString(airdate)
        parcel.writeString(airtime)
        parcel.writeString(airstamp)
        parcel.writeString(runtime)
        parcel.writeString(summary)
        parcel.writeParcelable(show, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class Links (
    @SerializedName("self")
    val self : Self
)

data class Self(
    @SerializedName("href")
    val href: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Self> {
        override fun createFromParcel(parcel: Parcel): Self {
            return Self(parcel)
        }

        override fun newArray(size: Int): Array<Self?> {
            return arrayOfNulls(size)
        }
    }
}

data class Show (

    @SerializedName("id")
    val id : String?,
    @SerializedName("url")
    val url : String?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("type")
    val type : String?,
    @SerializedName("language")
    val language : String?,
    @SerializedName("status")
    val status : String?,
    @SerializedName("premiered")
    val premiered : String?,
    @SerializedName("image")
    val image : ImageData?,
    @SerializedName("summary")
    val summary : String?,
    @SerializedName("genres")
    val genres : List<String>?

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(ImageData::class.java.classLoader),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(id)
        p0?.writeString(url)
        p0?.writeString(name)
        p0?.writeString(type)
        p0?.writeString(language)
        p0?.writeString(status)
        p0?.writeString(premiered)
        p0?.writeParcelable(image, p1)
        p0?.writeString(summary)
        p0?.writeStringList(genres)
    }

    companion object CREATOR : Parcelable.Creator<Show> {
        override fun createFromParcel(parcel: Parcel): Show {
            return Show(parcel)
        }

        override fun newArray(size: Int): Array<Show?> {
            return arrayOfNulls(size)
        }
    }
}

data class ImageData(
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("original")
    val original: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(medium)
        parcel.writeString(original)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageData> {
        override fun createFromParcel(parcel: Parcel): ImageData {
            return ImageData(parcel)
        }

        override fun newArray(size: Int): Array<ImageData?> {
            return arrayOfNulls(size)
        }
    }
}



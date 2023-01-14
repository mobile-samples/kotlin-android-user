package com.example.kotlin_android_user.company.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_android_user.commons.models.Info
import com.example.kotlin_android_user.commons.models.Tracking
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

// implement Parcelable to pass this variable between Activities using intent
@Entity(tableName = "company")
class Company constructor() : Tracking(){
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: String? = null

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    var name: String?= null

    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    var description: String?= null

    @ColumnInfo(name = "size")
    @SerializedName("size")
    @Expose
    var size: Int? = null

    @ColumnInfo(name = "status")
    @SerializedName("status")
    @Expose
    var status: String?= null

    @ColumnInfo(name = "establishedat")
    @SerializedName("establishedAt")
    @Expose
    var establishedAt: Date? = null

    @ColumnInfo(name = "categories")
    @SerializedName("categories")
    @Expose
    var categories: List<String>?= null

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    @Expose
    var imageURL: String?= null

    @ColumnInfo(name = "cover_url")
    @SerializedName("cover_url")
    @Expose
    var coverURL: String?= null

    @ColumnInfo(name = "info")
    @SerializedName("info")
    @Expose
    var info:Info? = null
}
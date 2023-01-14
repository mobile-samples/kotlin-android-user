package com.example.kotlin_android_user.commons.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


open class Tracking {
    @SerializedName("createdAt")
    @Expose
    var createdAt: Date? = null

    @SerializedName("createdBy")
    @Expose
    var createdBy: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: Date? = null

    @SerializedName("updatedBy")
    @Expose
    var updatedBy: String? = null
}
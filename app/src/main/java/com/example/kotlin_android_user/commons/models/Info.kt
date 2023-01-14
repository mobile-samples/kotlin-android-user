package com.example.kotlin_android_user.commons.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Info {
    @SerializedName("viewCount")
    @Expose
    var viewCount: Float = 0.0f

    @SerializedName("rate")
    @Expose
    var rate: Float = 0.0f

    @SerializedName("rate1")
    @Expose
    var rate1: Float = 0.0f

    @SerializedName("rate2")
    @Expose
    var rate2: Float = 0.0f

    @SerializedName("rate3")
    @Expose
    var rate3: Float = 0.0f

    @SerializedName("rate4")
    @Expose
    var rate4: Float = 0.0f

    @SerializedName("rate5")
    @Expose
    var rate5: Float = 0.0f
}

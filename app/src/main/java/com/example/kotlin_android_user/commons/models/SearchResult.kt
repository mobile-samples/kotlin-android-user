package com.example.kotlin_android_user.commons.models

data class SearchResult<T>(val list:List<T>,val total:Int, val nextPageToken:String, val last: Boolean)

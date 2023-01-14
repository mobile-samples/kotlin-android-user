package com.example.kotlin_android_user.commons.models

data class Resource<out T>(val status: Status, val data:T?, val messages: String?) {
    companion object{
        fun<T>success(data:T) = Resource(status = Status.SUCCESS, data = data, messages = null)
        fun<T>error(data:T?, messages: String?) = Resource(status = Status.SUCCESS, data = data, messages = messages)
        fun<T>loading(data:T?) = Resource(Status.LOADING, data, null)
    }
}
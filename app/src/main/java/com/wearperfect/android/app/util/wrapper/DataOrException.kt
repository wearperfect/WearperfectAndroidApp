package com.wearperfect.android.app.util.wrapper

data class DataOrException<T, Boolean, Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: Exception? = null
)

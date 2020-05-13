package com.sunasterisk.englishflashcard.data.source

interface OnDataLoadedCallback<T> {
    fun onSuccess(data: T)
    fun onFailed(exception: Exception)
}

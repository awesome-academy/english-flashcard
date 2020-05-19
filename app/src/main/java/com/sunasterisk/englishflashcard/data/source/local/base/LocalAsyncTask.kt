package com.sunasterisk.englishflashcard.data.source.local.base

import android.os.AsyncTask
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

const val FAILED: String = "FAILED"
const val LOAD_FAILED: String = "LOAD FAILED"

class LocalAsyncTask<P, T>(
    private val callback: OnDataLoadedCallback<T>,
    private val handle: (P) -> T
) : AsyncTask<P, Void, T?>() {

    override fun doInBackground(vararg params: P): T? =
        try {
            handle(params[0]) ?: throw Exception(FAILED)
        } catch (e: Exception) {
            null
        }

    override fun onPostExecute(result: T?) {
        result?.let {
            callback.onSuccess(it)
        } ?: callback.onFailed(Exception(LOAD_FAILED))
    }
}

object EmptyInput

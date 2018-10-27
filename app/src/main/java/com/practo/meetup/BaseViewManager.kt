package com.practo.meetup

interface BaseViewManager {
    fun handleError(connectionError: Boolean = false, error: String = "")
    fun handleEmpty(message: String = "")
    fun showProgressView(message: String = "")
    fun hideProgressView()
    fun setRetryCallback(retryCallback: () -> Unit)
}

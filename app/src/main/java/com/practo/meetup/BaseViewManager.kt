package com.practo.meetup

// A basic interface which manages UI states in View/ViewModel
interface BaseViewManager {
    
    // function with default value
    // rather than providing the param value at each call site we can set default values to function params 
    fun handleError(connectionError: Boolean = false, error: String = "")
    fun handleEmpty(message: String = "")
    fun showProgressView(message: String = "")
    fun hideProgressView()
    fun setRetryCallback(retryCallback: () -> Unit)
}

package com.practo.meetup

import android.content.res.Resources

// A dummy implementation for ViewManager interface
class BaseViewManagerImpl(val resources: Resources) : BaseViewManager {
    
    override fun setRetryCallback(retryCallback: () -> Unit) {
    }
    
    override fun handleEmpty(message: String) {
       // ...
    }
    
    /**
     * Hide progress view
     */
    override fun hideProgressView() {
        // ...
    }
    
    /**
     * Show progress view
     */
    override fun showProgressView(message: String) {
        // ...
    }
    
    /**
     * Handle API failure
     */
    override fun handleError(connectionError: Boolean, error: String) {
        // ...
    }
    
    private fun hideErrorView() {
        // ...
    }
    
    private fun hideEmptyView() {
        // ...
    }
}

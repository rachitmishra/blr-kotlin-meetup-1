package com.practo.meetup

import android.arch.lifecycle.ViewModel

/**
 * Interface delegation
 */
class MainViewModel_Delegation(val baseViewManagerImpl: BaseViewManagerImpl): ViewModel(), BaseViewManager by baseViewManagerImpl {

    init {

    }

    fun onApiResponse() {
        hideProgressView()
    }

    fun onApiError() {
        // Default values
        handleError()
    }

    // Delegate using property delegation
    val user by lazy(LazyThreadSafetyMode.NONE) {
        getUserFromDb()
    }
    fun getUserFromDb(): Unit = TODO()
}

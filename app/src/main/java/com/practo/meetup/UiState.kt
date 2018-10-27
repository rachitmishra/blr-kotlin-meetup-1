package com.practo.meetup

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

enum class UiState {
    ERROR,
    LOADING,
    LOADED,
    ERROR_CONNECTION
}


interface UiStateManager {

    fun initStateObserver(lifeCycle: LifecycleOwner, uiState: LiveData<UiState>) {
        uiState.observe(lifeCycle, Observer {
            when (it) {
                UiState.ERROR -> onError().invoke()
                UiState.LOADING -> onLoading().invoke()
                UiState.LOADED -> onLoaded().invoke()
                UiState.ERROR_CONNECTION -> onErrorConnection().invoke()
            }
        })
    }

    fun onError(): () -> Unit
    fun onErrorConnection(): () -> Unit
    fun onLoading(): () -> Unit
    fun onLoaded(): () -> Unit
}

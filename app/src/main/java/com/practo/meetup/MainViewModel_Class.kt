package com.practo.meetup

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Interface delegation
 */
class MainViewModel(): ViewModel()

    var selectedPosition = 0


    // Immutability with data classes
    val filters = Filters()


    fun changeFilter(newFilter: String) {
        filters = Filters().apply {
            filter2 = newFilter
        }

        // OR

        filters = Filters().copy(filter2 = newFilter)
    }

    // View objects with data classes
    var user = User("Rohan", "someUrl")

    // Sealed classes as Custom types

    sealed class AppointmentStatus {
        data class CheckedIn(val startTime: Long) : AppointmentStatus()
        object Waiting : AppointmentStatus()
        object Cancelled : AppointmentStatus()
        data class CheckedOut(val duration: Long): AppointmentStatus()
    }

    fun getAppointmentStatus(aptStatus: AppointmentStatus) {
        when(aptStatus) {
            is AppointmentStatus.CheckedIn -> {}
        }

    }

    // Inline classes 1.3


    // enum classes

}

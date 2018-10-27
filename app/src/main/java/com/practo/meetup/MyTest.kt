package com.practo.meetup

class MyTest {

    val viewModel = MainViewModel()

    fun testEx() {

        // Using standard library functions ex. apply
        viewModel.apply {
            isNotNull()
            selectedPosition isEqualTo 0
        }
    }

    // Using extensions and infix functions
    infix fun Any?.isEqualTo(check: Any?) {
        // Truth.assertThat(this).isEqualTo(check)
    }

    fun Any?.isNotNull() {
        // Truth.assertThat(this).isNotNull()
    }

    fun Any?.isNull() {
        // Truth.assertThat(this).isNull()
    }
}

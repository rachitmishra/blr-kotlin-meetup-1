package com.practo.meetup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), UiStateManager {

    // lateinit the viewModel it may not always be required once the class instance is being created
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When as expression
        val myString: Any? = true
        val typeOfMyStringIsBoolean =
            when(myString) {
                    is Boolean -> {
                        true
                    }
                    is String -> {
                        false
                    }

                    else {
                        false
                    }
                }

        // Higher order functions
        textView.setOnClickListener {
            // handleOnClick is our higher order function which takes a task function with signature () -> Unit
            handleOnClick {
                print("Clicked")
            }
        }

        // Using function references in case the lambda is not simplified
        textView.setOnClickListener(this::aSlightlyBiggerFun)
    }

    fun aSlightlyBiggerFun(v: View) {

    }

    override fun onError(): () -> Unit {
        TODO("not implemented")
    }

    override fun onErrorConnection(): () -> Unit {
        TODO("not implemented")
    }

    override fun onLoading(): () -> Unit {
        TODO("not implemented")
    }

    override fun onLoaded(): () -> Unit {
        TODO("not implemented")
    }


    // Top level function
    // Extension function
    // Pure function
    private fun View.scaleAnimate() {
        val animationDuration = 200L
        val scaleDownFactor = -0.02f
        val scaleUpFactor = 1f

        animate()
            .setDuration(animationDuration)
            .scaleXBy(scaleDownFactor)
            .scaleYBy(scaleDownFactor)
            .withEndAction {
                with(this) {
                    scaleX = scaleUpFactor
                    scaleY = scaleUpFactor
                }
            }

    }


    // local function
    private fun handleChangePassword(bundle: Bundle?) {

        fun getBroadcastIntent(wasRequestSuccessful: Boolean = false) =
            Intent(if (wasRequestSuccessful) {
                "change password success"
            } else {
                "change password failed"
            })


        if (bundle == null) {
            sendBroadcast(getBroadcastIntent(false))
            return
        }

        val result = false// save to db

        sendBroadcast(getBroadcastIntent(result))
    }

    fun sendLocalBroadcast(intent: Intent) = LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

    fun Activity.sendLocalBroadcast(intent: Intent) = LocalBroadcastManager.getInstance(this).sendBroadcast(intent)


    // higher order functions
    private fun handleOnClick(onClick: () -> Unit) {
        // Record click event
        onClick.invoke()
    }
}

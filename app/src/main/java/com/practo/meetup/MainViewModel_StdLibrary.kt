package com.practo.meetup

import android.arch.lifecycle.ViewModel

/**
 * Interface delegation
 */
class MainViewModel_StdLibrary() : ViewModel() {

    data class Subscription(val serviceName: String, val expiredOn: String?, val active: Boolean)

    val subscriptions = (1..4).map { Subscription(it.toString(), if (it / 2 == 0) null else "Ok", (it / 2 == 0)) }

    // Ex.1
    fun hasActiveSubs() {

        var hasSubcription = false
        for (sub in subscriptions) {
            if (sub.expiredOn != null) {
                hasSubcription = true
            }
        }

        // OR ...

        subscriptions.asSequence().map { it.expiredOn }.any { it != null }
        subscriptions.any { it.expiredOn != null }
    }


    // Ex.2
    fun serviceActive() {
        var hasSubcription = false
        for (sub in subscriptions) {
            if (sub.serviceName == "One" && sub.active) {

            }
        }

        // OR ...
        subscriptions.find { it.serviceName == "MYSERVICE" && it.active } != null
    }

    // Ex.3
    val triple = { x: Int -> x * 3 }

    fun isGreaterThan5(x: Int) = x > 5

    fun ex3() {
        listOf(1, 2, 3)
            .map(triple)
            .filter(::isGreaterThan5)
            .forEach {
                println("Survived: $it")
            }
    }

    // Ex.4
    data class ASubscription(var active: Boolean)

    data class SubscriptionClubbed(
        var keyword: String = "",
        var subscriptions: List<ASubscription> = emptyList()
    ) {

        val totalActiveSubscriptions: Int by lazy(LazyThreadSafetyMode.NONE) {
            subscriptions.filter { it.active }.count()
        }
    }

    var subscriptionClubbed: List<SubscriptionClubbed> = emptyList()

    fun getSubscriptionsGroupByKeyword(): List<Any> {
        return subscriptionClubbed.groupBy {
            it.keyword
        }.flatMap {
            listOf(it.key, *(it.value.sortedByDescending { it.totalActiveSubscriptions }.toTypedArray()))
        }
    }

    fun getMaxActiveSubscriptions() = subscriptionClubbed.asSequence().map { it.totalActiveSubscriptions }.max() ?: 0

}

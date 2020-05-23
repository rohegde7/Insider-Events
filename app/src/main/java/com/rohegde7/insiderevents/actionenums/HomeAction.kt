package com.rohegde7.insiderevents.actionenums

enum class HomeAction(var message: String = "") {
    FETCHING_HOME_DATA,
    HOME_DATA_FETCHED,
    FETCHING_HOME_DATA_FAILED
}
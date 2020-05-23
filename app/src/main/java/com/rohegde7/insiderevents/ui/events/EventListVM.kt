package com.rohegde7.insiderevents.ui.events

import androidx.lifecycle.ViewModel
import com.rohegde7.insiderevents.pojo.Featured

class EventListVM : ViewModel() {

    val mRepository = EventListRepo()

    val homeAction = mRepository.homeAction

    fun getFeaturedEvents(): List<Featured> {
        return mRepository.homeData.featured
    }

    fun fetchHomeData() {
        mRepository.fetchHomeData()
    }
}
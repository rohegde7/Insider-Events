package com.rohegde7.insiderevents.ui.events

import androidx.lifecycle.MutableLiveData
import com.rohegde7.insiderevents.actionenums.HomeAction
import com.rohegde7.insiderevents.api.EventApi
import com.rohegde7.insiderevents.network.RetrofitProvider
import com.rohegde7.insiderevents.pojo.HomeData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class EventListRepo {

    private val mEventApi: EventApi = RetrofitProvider.mRetrofit.create(EventApi::class.java)

    lateinit var homeData: HomeData
    val homeAction = MutableLiveData<HomeAction>()

    fun fetchHomeData() {
        homeAction.value = HomeAction.FETCHING_HOME_DATA

        mEventApi
            .getHomeData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<HomeData> {
                override fun onSuccess(response: HomeData) {
                    homeData = response
                    homeAction.value = HomeAction.HOME_DATA_FETCHED
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    homeAction.value = HomeAction.FETCHING_HOME_DATA_FAILED
                }
            })
    }
}
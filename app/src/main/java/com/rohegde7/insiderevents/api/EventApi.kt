package com.rohegde7.insiderevents.api

import com.rohegde7.insiderevents.pojo.HomeData
import io.reactivex.Single
import retrofit2.http.GET

interface EventApi {

    // TODO remove hard coded Query Param
    //  Currently HARD coding the query param because we have only 1 URL available as for this demo app
    @GET("home?norm=1&filterBy=go-out&city=mumbai")
    fun getHomeData(): Single<HomeData>
}
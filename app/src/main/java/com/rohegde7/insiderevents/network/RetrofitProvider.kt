package com.rohegde7.insiderevents.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.rohegde7.insiderevents.network.interceptors.LoggerInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    val gson = GsonBuilder()
        .setLenient()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    val mRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.insider.in/")
            .client(getMyHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    private fun getMyHttpClient(): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addNetworkInterceptor(LoggerInterceptor())
        return builder.build()
    }
}
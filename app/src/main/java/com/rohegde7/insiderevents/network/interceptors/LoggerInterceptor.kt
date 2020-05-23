package com.rohegde7.insiderevents.network.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class LoggerInterceptor : Interceptor {
    private val API_HIT = "API hit"
    private val API_RESPONSE_RECEIVED = "API response received"


    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        Log.e(API_HIT, "${request.url()}")

        val response = chain.proceed(request)

        Log.e(API_RESPONSE_RECEIVED, "${request.url()}")

        return response
    }
}
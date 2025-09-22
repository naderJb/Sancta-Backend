package com.sancta.base.client

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor(
    private val apiKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val requestWithHeaders = original.newBuilder()
            .header("api-key", apiKey)
            .build()
        return chain.proceed(requestWithHeaders)
    }
}
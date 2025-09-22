package com.sancta.base.client

import com.google.gson.Gson
import com.sancta.bible.book.BibleRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Configuration
class RetrofitProvider {

    @Bean
    fun providesGson() = Gson()

    @Bean
    fun providesGsonFactory(
        gson: Gson
    ): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Bean
    fun providesLoginInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Bean
    fun provideHeaderInterceptor(
        @Value($$"${api.key}") apiKey: String,
    ): HeaderInterceptor = HeaderInterceptor(apiKey)

    @Bean
    fun providesOkHttpClient(
        loginInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loginInterceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    @Bean
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.scripture.api.bible/v1/")
        .client(okHttpClient)
        .addConverterFactory(gsonFactory)
        .build()

    @Bean
    fun providesAppService(retrofit: Retrofit): BibleRepository = retrofit.create(BibleRepository::class.java)
}
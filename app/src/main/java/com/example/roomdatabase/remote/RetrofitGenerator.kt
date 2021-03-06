package com.example.roomdatabase.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGenerator {

    companion object {
        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getContactInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://dd027c0c-6c86-4fdf-bbc9-810dfbeed120.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }

        fun getEventInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://beb5c439-8696-4942-94a3-2f851d17411f.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .build()
        }
    }

}
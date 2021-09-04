package com.example.khabarzone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiUtilities() {

    var retrofit: Retrofit? = null

    fun getApiInterface() : ApiInterface? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

        }

        return retrofit?.create(ApiInterface::class.java)
    }

}
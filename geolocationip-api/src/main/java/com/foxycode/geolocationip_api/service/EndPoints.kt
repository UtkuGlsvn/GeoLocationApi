package com.foxycode.geolocationip_api.service

import com.foxycode.geolocationip_api.model.IpApiModel
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("/json")
    fun getUserDetail(): Call<IpApiModel>
}
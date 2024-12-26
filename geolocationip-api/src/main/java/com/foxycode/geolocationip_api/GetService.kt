package com.foxycode.geolocationip_api

import android.util.Log
import com.foxycode.geolocationip_api.model.IpApiModel
import com.foxycode.geolocationip_api.service.EndPoints
import com.foxycode.geolocationip_api.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetService {

    companion object {
        private val request = ServiceBuilder.buildService(EndPoints::class.java)
        private val call = request.getUserDetail()
        private var instance: GetService? = null
    }

    fun Instance(): GetService {
        if (instance == null) {
            instance = GetService()
        }
        return instance as GetService
    }

    fun getModel(listener : ResponseListener) {
        call.enqueue(object : Callback<IpApiModel> {
            override fun onFailure(call: Call<IpApiModel>, t: Throwable) {
                listener.onErrorResult("Error")
                Log.e("Error",""+t.message)
            }

            override fun onResponse(call: Call<IpApiModel>, response: Response<IpApiModel>) {
                if (response.isSuccessful) {
                    if (response.body() != null)
                        listener.onSuccessResult(response.body()!!)
                }
            }
        })
    }

}
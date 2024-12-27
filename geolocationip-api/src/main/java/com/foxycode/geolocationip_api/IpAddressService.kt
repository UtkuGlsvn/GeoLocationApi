package com.foxycode.geolocationip_api

import com.foxycode.geolocationip_api.model.IpApiModel
import com.foxycode.geolocationip_api.service.EndPoints
import com.foxycode.geolocationip_api.service.ResponseListener
import com.foxycode.geolocationip_api.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IpAddressService {
    companion object {
        private var instance: IpAddressService? = null
        private val request: EndPoints by lazy { ServiceBuilder.buildService(EndPoints::class.java) }

        fun instance(): IpAddressService {
            if (instance == null) {
                instance = IpAddressService()
            }
            return instance!!
        }
    }

    fun getModel(listener: ResponseListener) {
        val call = request.getUserDetail()
        call.enqueue(object : Callback<IpApiModel> {
            override fun onFailure(call: Call<IpApiModel>, t: Throwable) {
                listener.onErrorResult("Network error: ${t.message}")
            }

            override fun onResponse(call: Call<IpApiModel>, response: Response<IpApiModel>) {
                if (response.isSuccessful && response.body() != null) {
                    listener.onSuccessResult(response.body()!!)
                } else {
                    listener.onErrorResult("Error fetching data")
                }
            }
        })
    }
}
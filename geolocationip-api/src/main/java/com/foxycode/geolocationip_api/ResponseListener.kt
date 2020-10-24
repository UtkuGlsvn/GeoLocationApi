package com.foxycode.geolocationip_api

import com.foxycode.geolocationip_api.model.IpApiModel

interface ResponseListener {
    fun onSuccessResult(obj: IpApiModel)
    fun onErrorResult(msg: String)
}
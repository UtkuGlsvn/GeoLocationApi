package com.foxycode.geolocationip_api

import com.foxycode.geolocationip_api.model.IpApiModel

interface IpAddressView {
    fun showData(model: IpApiModel)
    fun showError(msg: String)
}

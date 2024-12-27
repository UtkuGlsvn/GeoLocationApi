package com.foxycode.geolocationip_api

import com.foxycode.geolocationip_api.model.IpApiModel
import com.foxycode.geolocationip_api.service.ResponseListener

class IpAddressPresenter(private val view: IpAddressView) {

    private val ipAddressService = IpAddressService.instance()


    fun getUserDetails() {
        ipAddressService.getModel(object : ResponseListener {
            override fun onSuccessResult(obj: IpApiModel) {
                view.showData(obj)
            }

            override fun onErrorResult(msg: String) {
                view.showError(msg)
            }
        })
    }
}

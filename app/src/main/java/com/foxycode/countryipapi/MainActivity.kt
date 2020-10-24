package com.foxycode.countryipapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.foxycode.geolocationip_api.GetService
import com.foxycode.geolocationip_api.ResponseListener
import com.foxycode.geolocationip_api.model.IpApiModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ResponseListener {


    private lateinit var getService: GetService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getService = GetService().Instance()
        getService.getModel(this)
    }

    override fun onSuccessResult(obj: IpApiModel) {
        txtViewCountry.text=obj.country
        txtViewIp.text=obj.ipQuery
        txtViewCountryCode.text=obj.countryCode
        txtViewCity.text=obj.city
        txtViewRegion.text=obj.region.toString()
    }


    override fun onErrorResult(msg: String) {
        Log.e("error", msg)
    }

}
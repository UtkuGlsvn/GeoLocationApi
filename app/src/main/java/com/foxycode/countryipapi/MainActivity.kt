package com.foxycode.countryipapi;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.foxycode.countryipapi.databinding.ActivityMainBinding
import com.foxycode.geolocationip_api.GetService
import com.foxycode.geolocationip_api.ResponseListener
import com.foxycode.geolocationip_api.model.IpApiModel

class MainActivity : AppCompatActivity(), ResponseListener {

    private lateinit var getService: GetService
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getService = GetService().Instance()
        getService.getModel(this)
    }

    override fun onSuccessResult(obj: IpApiModel) {
        runOnUiThread {
            binding.txtViewCountry.text = obj.country
            binding.txtViewIp.text = obj.isp
            binding.txtViewCountryCode.text = obj.countryCode
            binding.txtViewCity.text = obj.city
            binding.txtViewRegion.text = obj.region
        }
    }


    override fun onErrorResult(msg: String) {
        Log.e("error", msg)
    }
}
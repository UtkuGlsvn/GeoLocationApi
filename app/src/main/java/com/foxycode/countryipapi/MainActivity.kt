package com.foxycode.countryipapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.foxycode.countryipapi.databinding.ActivityMainBinding
import com.foxycode.geolocationip_api.IpAddressPresenter
import com.foxycode.geolocationip_api.IpAddressView
import com.foxycode.geolocationip_api.model.IpApiModel

class MainActivity : AppCompatActivity(), IpAddressView {

    private lateinit var presenter: IpAddressPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = IpAddressPresenter(this)
        presenter.getUserDetails()
    }

    override fun showData(model: IpApiModel) {
        runOnUiThread {
            binding.txtViewCountry.text = model.country
            binding.txtViewIp.text = model.ipQuery
            binding.txtViewCountryCode.text = model.countryCode
            binding.txtViewCity.text = model.city
            binding.txtViewRegion.text = model.region
        }
    }

    override fun showError(msg: String) {
        runOnUiThread {
            Toast.makeText(this, "network error $msg", Toast.LENGTH_SHORT).show()
        }
    }
}


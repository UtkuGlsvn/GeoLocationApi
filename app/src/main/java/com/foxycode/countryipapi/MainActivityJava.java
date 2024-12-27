package com.foxycode.countryipapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.foxycode.countryipapi.databinding.ActivityMainJavaBinding;
import com.foxycode.geolocationip_api.IpAddressPresenter;
import com.foxycode.geolocationip_api.IpAddressView;
import com.foxycode.geolocationip_api.model.IpApiModel;


public class MainActivityJava extends AppCompatActivity implements IpAddressView {

    private final IpAddressPresenter presenter = new IpAddressPresenter(this);
    private ActivityMainJavaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter.getUserDetails();
        initView();
    }

    private void initView() {

    }

    @Override
    public void showData(@NonNull IpApiModel model) {
        runOnUiThread(() -> {
            binding.txtViewCountry.setText(model.getCountry());
            binding.txtViewIp.setText(model.getIpQuery());
            binding.txtViewCountryCode.setText(model.getCountryCode());
            binding.txtViewRegion.setText(model.getRegionName());
            binding.txtViewCity.setText(model.getCity());
        });
    }

    @Override
    public void showError(@NonNull String msg) {

    }
}
package com.foxycode.countryipapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.foxycode.countryipapi.databinding.ActivityMainJavaBinding;
import com.foxycode.geolocationip_api.GetService;
import com.foxycode.geolocationip_api.ResponseListener;
import com.foxycode.geolocationip_api.model.IpApiModel;

import org.jetbrains.annotations.NotNull;


public class MainActivityJava extends AppCompatActivity implements ResponseListener {

    private final GetService getService = new GetService();
    private ActivityMainJavaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getService.Instance().getModel(this);
        initView();
    }

    private void initView() {

    }

    @Override
    public void onSuccessResult(@NotNull IpApiModel obj) {
        runOnUiThread(() -> {
            binding.txtViewCountry.setText(obj.getCountry());
            binding.txtViewIp.setText(obj.getIsp());
            binding.txtViewCountryCode.setText(obj.getCountryCode());
            binding.txtViewRegion.setText(obj.getRegionName());
            binding.txtViewCity.setText(obj.getCity());
        });
    }

    @Override
    public void onErrorResult(@NotNull String msg) {
        Log.e("error", msg);
    }
}
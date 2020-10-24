package com.foxycode.countryipapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.foxycode.geolocationip_api.GetService;
import com.foxycode.geolocationip_api.ResponseListener;
import com.foxycode.geolocationip_api.model.IpApiModel;

import org.jetbrains.annotations.NotNull;

public class MainActivityJava extends AppCompatActivity implements ResponseListener {

    private GetService getService = new GetService();
    TextView txtViewCountry,txtViewIp,txtViewCountryCode,txtViewRegion,txtViewCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);
        getService.Instance().getModel(this);
        initView();
    }

    private void initView()
    {
        txtViewCity=findViewById(R.id.txtViewCity);
        txtViewCountry=findViewById(R.id.txtViewCountry);
        txtViewIp=findViewById(R.id.txtViewIp);
        txtViewCountryCode=findViewById(R.id.txtViewCountryCode);
        txtViewRegion=findViewById(R.id.txtViewRegion);
    }
    @Override
    public void onSuccessResult(@NotNull IpApiModel obj) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtViewCountry.setText(obj.getCountry());
                txtViewIp.setText(obj.getIpQuery());
                txtViewCountryCode.setText(obj.getCountryCode());
                txtViewRegion.setText(obj.getRegionName());
                txtViewCity.setText(obj.getCity());
            }
        });
    }

    @Override
    public void onErrorResult(@NotNull String msg) {
        Log.e("error", msg);
    }
}
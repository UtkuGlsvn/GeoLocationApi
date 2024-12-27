# GeoLocationApi

The GitHub repository "GeoLocationApi" by UtkuGlsvn is an Android library that uses Retrofit and Kotlin to request geographic location information from IP-API.com. The library provides functionalities to retrieve data such as IP address, country, country code, city, and region. Users can add the library to their projects by including it in their build.gradle dependencies and utilize it in Android applications to access location details programmatically.



IP-API(http://ip-api.com/json) send request  for Android platform using Retrofit and kotlin. Get your geographic location information. Ip adress, country, country code etc

<img src="https://github.com/UtkuGlsvn/GeoLocationApi/blob/master/ExampleApp.jpeg" width="250" height="350">

## HOW TO USE


Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.UtkuGlsvn:GeoLocationApi:1.1.0'
	}


### Kotlin Example

    class MainActivity : AppCompatActivity(), ResponseListener {

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
    
![Kotlin Example Full Code](https://github.com/UtkuGlsvn/GeoLocationApi/blob/master/app/src/main/java/com/foxycode/countryipapi/MainActivity.kt "Kotlin Code Example")    

### Java Example


    public class MainActivityJava extends AppCompatActivity implements ResponseListener {
   
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
    
    
    
 ![Java Example Full Code](https://github.com/UtkuGlsvn/GeoLocationApi/blob/master/app/src/main/java/com/foxycode/countryipapi/MainActivityJava.java "Java Code Example")    

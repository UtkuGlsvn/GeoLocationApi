package com.foxycode.geolocationip_api.model

import com.google.gson.annotations.SerializedName

class IpApiModel {
    @SerializedName("status")
    var status: String?=null
    @SerializedName("country")
    var country: String?=null
    @SerializedName("countryCode")
    var countryCode: String?=null
    @SerializedName("region")
    var region: Int?=null
    @SerializedName("regionName")
    var regionName: String?=null
    @SerializedName("city")
    var city: String?=null
    @SerializedName("zip")
    var zip: Int?=null
    @SerializedName("lat")
    var lat: Double?=null
    @SerializedName("lon")
    var lon: Double?=null
    @SerializedName("timezone")
    val timezone: String?=null
    @SerializedName("isp")
    var isp: String?=null
    @SerializedName("org")
    var org: String?=null
    @SerializedName("as")
    var ispAs: String?=null
    @SerializedName("query")
    var ipQuery: String?=null
}

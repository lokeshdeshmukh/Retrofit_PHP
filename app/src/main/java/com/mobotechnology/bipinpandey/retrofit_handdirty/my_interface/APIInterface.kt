package com.mobotechnology.bipinpandey.retrofit_handdirty.my_interface

import com.mobotechnology.bipinpandey.retrofit_handdirty.model.SampleData
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @get:GET("atestphp.php")
    val defaultData: Call<SampleData?>?
}
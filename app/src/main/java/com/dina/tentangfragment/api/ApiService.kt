package com.dina.tentangfragment.api

import com.dina.tentangfragment.model.ResponseUser
import com.dina.tentangfragment.model.ResponseWisata
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("wisata")
    fun getWisata() : Call<ResponseWisata>

    @FormUrlEncoded
    @POST("login")
    fun loginYuk(
        @Field("email") email : String,
        @Field("password") password : String,
    ) : Call<ResponseUser>

    @FormUrlEncoded
    @POST("regis")
    fun regisYuk(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("phone") phone : String,
        @Field("password") password : String,
        @Field("city") city : String,
    ) : Call<ResponseUser>


}
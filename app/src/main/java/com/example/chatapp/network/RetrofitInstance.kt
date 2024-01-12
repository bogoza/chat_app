package com.example.chatapp.network

import com.example.chatapp.data.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET


object RetrofitInstance {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(moshi)
            .build()
            .create(UserApi::class.java)
    }
    private val moshi: MoshiConverterFactory = MoshiConverterFactory.create(Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build())


//    val getApi:UserApi by lazy {
//        retrofit.create(UserApi::class.java)
//    }
}
interface UserApi{
    @GET("744fa574-a483-43f6-a1d7-c65c87b5d9b2")
    suspend fun getPost(): List<User>
}
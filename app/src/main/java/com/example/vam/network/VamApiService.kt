package com.example.vam.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =""

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface VamApiService {
    /**
     * Returns a Coroutine [List] of [MarsProperty] which can be fetched in a Coroutine scope.
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("QR")
    suspend fun getProperties(): List<QrProperty>
}

object VamApi {
    val retrofitService : VamApiService by lazy { retrofit.create(VamApiService::class.java) }
}

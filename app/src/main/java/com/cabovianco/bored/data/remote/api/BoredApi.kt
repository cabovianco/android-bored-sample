package com.cabovianco.bored.data.remote.api

import com.cabovianco.bored.data.remote.dto.ActivityDto
import retrofit2.Response
import retrofit2.http.GET

interface BoredApi {
    @GET("random")
    suspend fun getRandomActivity(): Response<ActivityDto>
}

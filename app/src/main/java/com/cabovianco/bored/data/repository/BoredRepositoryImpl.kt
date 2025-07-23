package com.cabovianco.bored.data.repository

import com.cabovianco.bored.data.remote.api.BoredApi
import com.cabovianco.bored.data.remote.dto.toDomain
import com.cabovianco.bored.domain.model.Activity
import com.cabovianco.bored.domain.repository.BoredRepository
import javax.inject.Inject

class BoredRepositoryImpl @Inject constructor(
    private val boredApi: BoredApi
) : BoredRepository {
    override suspend fun getRandomActivity(): Result<Activity> {
        return try {
            val response = boredApi.getRandomActivity()
            val activityDto = response.body()

            if (!response.isSuccessful || activityDto == null) {
                Result.failure(Exception("Error API: ${response.code()}"))
            } else {
                Result.success(activityDto.toDomain())
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

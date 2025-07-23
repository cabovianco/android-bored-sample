package com.cabovianco.bored.domain.repository

import com.cabovianco.bored.domain.model.Activity

interface BoredRepository {
    suspend fun getRandomActivity(): Result<Activity>
}

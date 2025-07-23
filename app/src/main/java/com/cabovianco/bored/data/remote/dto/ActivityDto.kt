package com.cabovianco.bored.data.remote.dto

import com.cabovianco.bored.domain.model.Activity
import kotlinx.serialization.Serializable

@Serializable
data class ActivityDto(val activity: String)

fun ActivityDto.toDomain() = Activity(activity = activity)

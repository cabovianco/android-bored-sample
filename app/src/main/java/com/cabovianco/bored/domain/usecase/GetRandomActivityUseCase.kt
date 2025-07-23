package com.cabovianco.bored.domain.usecase

import com.cabovianco.bored.domain.repository.BoredRepository
import javax.inject.Inject

class GetRandomActivityUseCase @Inject constructor(
    private val boredRepository: BoredRepository
){
    suspend operator fun invoke() =
        boredRepository.getRandomActivity()
}

package com.fdegarne.look4it.techtest.core.data.usecases

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengeOfDayRepository
import com.fdegarne.look4it.techtest.core.data.repositories.LocationRepository
import java.time.LocalDate
import javax.inject.Inject

class CreateChallengeOfDayUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    private val challengeOfDayRepository: ChallengeOfDayRepository
) {
    suspend operator fun invoke(baseText: String) {
        locationRepository.getLocations().collect { locations ->
            if (locations.isNotEmpty()) {
                val date = LocalDate.now()

                val randomId = locations.indices.random()
                val existingChallengeOfDay = challengeOfDayRepository.countChallengeOfDay(
                    date = date,
                    false
                )

                if (existingChallengeOfDay == 0) {
                    challengeOfDayRepository.createChallengeOfDay(
                        ChallengeOfDay(
                            date = date,
                            locationId = randomId.toLong(),
                            description = String.format(baseText, locations[randomId].title)
                        )
                    )
                }
            }
        }
    }
}
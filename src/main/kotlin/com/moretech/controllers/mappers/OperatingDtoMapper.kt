package com.moretech.controllers.mappers

import com.model.DayDto
import com.model.OpenHoursDto
import com.model.OperatingModeDto
import com.moretech.entities.Department
import com.moretech.entities.OpenHours
import java.time.LocalTime
import kotlin.random.Random

class OperatingDtoMapper {
    companion object {
        fun mapOpenHoursToOperatingDto(openHours: OpenHours) : OperatingModeDto {
            return OperatingModeDto()
                .workload(generateSchedule(openHours))
                .day(DayDtoMapper.mapDayEnumToDayDto(openHours.day))
                .openHours(OpenHoursDtoMapper.mapOpenHoursToOpenHoursDto(openHours))
        }

        fun generateSchedule(openHours: OpenHours) : Map<String, Int> {
            val hours = mutableMapOf<String, Int>()
            var current = openHours.startTime
            while (current!!.isBefore(openHours.endTime)) {
                val workload = generateRandomWorkload(openHours, current.toString())
                hours.put(current.toString(), workload)
                current = current.plusHours(1)
            }
            val workload = generateRandomWorkload(openHours, current.toString())
            hours.put(current.toString(), workload)
            return hours
        }

        fun generateRandomWorkload(openHours: OpenHours, time: String) : Int {
            val seed = openHours.department?.id!! + openHours.day.hashCode() + time.hashCode() + openHours.typeWork.hashCode()
            return Random(seed).nextInt(0, 101)
        }
    }
}
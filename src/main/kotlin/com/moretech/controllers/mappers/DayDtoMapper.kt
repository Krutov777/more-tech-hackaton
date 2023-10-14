package com.moretech.controllers.mappers

import com.model.DayDto
import com.moretech.entities.OpenHours

class DayDtoMapper {
    companion object {
        fun mapDayEnumToDayDto(day: OpenHours.Days?) : DayDto = when (day) {
            OpenHours.Days.MONDAY -> DayDto.MONDAY
            OpenHours.Days.TUESDAY -> DayDto.TUESDAY
            OpenHours.Days.WEDNESDAY -> DayDto.WEDNESDAY
            OpenHours.Days.THURSDAY -> DayDto.THURSDAY
            OpenHours.Days.FRIDAY -> DayDto.FRIDAY
            OpenHours.Days.SATURDAY -> DayDto.SATURDAY
            OpenHours.Days.SUNDAY -> DayDto.SUNDAY
            else -> DayDto.MONDAY
        }
    }
}
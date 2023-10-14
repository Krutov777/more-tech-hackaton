package com.moretech.controllers.mappers

import com.model.DayDto
import com.moretech.entities.OpenHoursKey

class DayDtoMapper {
    companion object {
        fun mapDayEnumToDayDto(day: OpenHoursKey.Days?) : DayDto = when (day) {
            OpenHoursKey.Days.MONDAY -> DayDto.MONDAY
            OpenHoursKey.Days.TUESDAY -> DayDto.TUESDAY
            OpenHoursKey.Days.WEDNESDAY -> DayDto.WEDNESDAY
            OpenHoursKey.Days.THURSDAY -> DayDto.THURSDAY
            OpenHoursKey.Days.FRIDAY -> DayDto.FRIDAY
            OpenHoursKey.Days.SATURDAY -> DayDto.SATURDAY
            OpenHoursKey.Days.SUNDAY -> DayDto.SUNDAY
            else -> DayDto.MONDAY
        }
    }
}
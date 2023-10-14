package com.moretech.controllers.mappers

import com.model.OpenHoursDto
import com.moretech.entities.OpenHours

class OpenHoursDtoMapper {
    companion object {
        fun mapOpenHoursToOpenHoursDto(openHours: OpenHours) : OpenHoursDto {
            return OpenHoursDto()
                .from(openHours.startTime.toString())
                .to(openHours.endTime.toString())
        }
    }
}
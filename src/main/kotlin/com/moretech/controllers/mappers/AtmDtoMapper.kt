package com.moretech.controllers.mappers

import com.model.AtmInfoResponseDto
import com.model.CoordinateDto
import com.moretech.entities.Atm

class AtmDtoMapper {
    companion object {
        fun mapAtmToAtmDto(atm: Atm): AtmInfoResponseDto {
            return AtmInfoResponseDto()
                .id(atm.id)
                .address(atm.address)
                .metroStation(atm.metroStation)
                .allDay(atm.allDay)
                .distance(atm.distance?.toLong() ?: 0)
                .coordinates(
                    CoordinateDto()
                    .latitude(atm.latitude?.toBigDecimal())
                    .longitude(atm.longitude?.toBigDecimal())
                )
                .services(listOf())
        }
    }
}
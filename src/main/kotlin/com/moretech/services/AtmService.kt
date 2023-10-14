package com.moretech.services

import com.model.AtmInfoResponseDto
import com.model.CoordinateDto
import com.model.ServiceDto
import com.moretech.entities.ServiceAtm
import com.moretech.repositories.AtmRepository
import com.moretech.repositories.ServiceAtmRepository
import com.moretech.repositories.ServiceRepository
import org.springframework.stereotype.Service

@Service
class AtmService(
    private val atmRepository: AtmRepository,
    private val serviceAtmRepository: ServiceAtmRepository,
    private val serviceRepository: ServiceRepository,
) {
    fun getAtmById(atmId: Long): AtmInfoResponseDto {
        val atm = atmRepository.findById(atmId).get()
        val serviceAtm: List<ServiceAtm> = atm.id?.let { serviceAtmRepository.findAllByAtmId(it) } ?: listOf()
        val serviceList: List<com.moretech.entities.Service> = serviceAtm.map { it.id?.serviceId }.let { serviceRepository.findAllByIdIn(it as List<Long>) }
        val serviceListDto: List<ServiceDto> = serviceList.map { elem ->
            ServiceDto()
                .id(elem.id)
                .name(elem.name)
                .serviceActivity(
                    serviceAtm.find { it.id?.serviceId == elem.id }?.serviceActivity.toString()
                )
                .serviceCapability(
                    serviceAtm.find { it.id?.serviceId == elem.id }?.serviceCapacity.toString()
                )
        }
        return AtmInfoResponseDto()
            .id(atm.id)
            .address(atm.address)
            .metroStation(atm.metroStation)
            .allDay(atm.allDay)
            .distance(atm.distance?.toLong() ?: 0)
            .coordinates(CoordinateDto()
                .latitude(atm.latitude?.toBigDecimal())
                .longitude(atm.longitude?.toBigDecimal())
            )
            .services(serviceListDto)
    }
}
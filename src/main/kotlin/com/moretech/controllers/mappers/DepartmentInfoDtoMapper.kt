package com.moretech.controllers.mappers

import com.model.CoordinateDto
import com.model.DepartmentInfoResponseDto
import com.model.DepartmentStatusDto
import com.moretech.entities.*
import kotlin.random.Random

class DepartmentInfoDtoMapper {
    companion object {
        fun mapDepartmentEntityToDepartmentInfoDto(
            department: Department,
            services: List<ServiceDepartment>,
            clientTypes: List<ClientType>,
            openHours: List<OpenHours>
        ): DepartmentInfoResponseDto {
            return DepartmentInfoResponseDto()
                .id(department.id)
                .address(department.address)
                .distance(department.distance?.toLong())
                .hasRamp(department.hasRamp)
                .coordinates(CoordinateDto()
                    .latitude(department.latitude?.toBigDecimal())
                    .longitude(department.longitude?.toBigDecimal())
                )
                .metroStation(department.metroStation)
                .status(mapDepartmentStatusToDepartmentStatusDto(department.status))
                .workload(Random(department.id ?: 0L).nextInt(0,101))
                .individual(
                    openHours
                        .filter { it.id?.typeWork == OpenHoursKey.TypeWork.INDIVIDUAL }
                        .sortedBy { it.id?.day }
                        .map {
                            OperatingDtoMapper.mapOpenHoursToOperatingDto(it)
                        }
                )
                .legal(
                    openHours
                        .filter { it.id?.typeWork == OpenHoursKey.TypeWork.LEGAL }
                        .sortedBy { it.id?.day }
                        .map {
                            OperatingDtoMapper.mapOpenHoursToOperatingDto(it)
                        }
                )
                .services(
                    services.map { ServiceDtoMapper.mapServiceDepartmentToServiceDto(it) }
                )
                .clients(
                    clientTypes.map { ClientDtoMapper.mapClientTypeToClientDto(it) }
                )
        }

        private fun mapDepartmentStatusToDepartmentStatusDto(status: String?): DepartmentStatusDto = when (status) {
            "OPEN" -> DepartmentStatusDto.OPEN
            "CLOSED" -> DepartmentStatusDto.CLOSED
            "TECHNICAL_PROBLEMS" -> DepartmentStatusDto.TECHNICAL_PROBLEMS
            else -> DepartmentStatusDto.TECHNICAL_PROBLEMS
        }
    }
}
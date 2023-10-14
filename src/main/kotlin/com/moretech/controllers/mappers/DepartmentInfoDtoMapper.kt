package com.moretech.controllers.mappers

import com.model.*
import com.moretech.entities.Department
import com.moretech.entities.OpenHours

class DepartmentInfoDtoMapper {
    companion object {
        fun mapDepartmentEntityToDepartmentInfoDto(department: Department): DepartmentInfoResponseDto {
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
                //.workload(department)
                .individual(
                    department.openHours
                        ?.filter { it.typeWork == OpenHours.TypeWork.INDIVIDUAL }
                        ?.map {
                            OperatingDtoMapper.mapOpenHoursToOperatingDto(it)
                        } ?: listOf()
                )
                .legal(
                    department.openHours
                        ?.filter { it.typeWork == OpenHours.TypeWork.LEGAL }
                        ?.map {
                            OperatingDtoMapper.mapOpenHoursToOperatingDto(it)
                        } ?: listOf()
                )
                //todo clients and services mappers
        }

        fun mapDepartmentStatusToDepartmentStatusDto(status: String?): DepartmentStatusDto = when (status) {
            "OPEN" -> DepartmentStatusDto.OPEN
            "CLOSED" -> DepartmentStatusDto.CLOSED
            "TECHNICAL_PROBLEMS" -> DepartmentStatusDto.TECHNICAL_PROBLEMS
            else -> DepartmentStatusDto.TECHNICAL_PROBLEMS
        }
    }
}
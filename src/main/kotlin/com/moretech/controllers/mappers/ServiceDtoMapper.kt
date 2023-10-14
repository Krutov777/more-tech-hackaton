package com.moretech.controllers.mappers

import com.model.ServiceDto
import com.moretech.entities.ServiceDepartment

class ServiceDtoMapper {
    companion object {
        fun mapServiceDepartmentToServiceDto(serviceDepartment: ServiceDepartment) : ServiceDto {
            return ServiceDto()
                .id(serviceDepartment.id?.serviceId)
                .name(serviceDepartment.service?.name)
        }
    }
}
package com.moretech.controllers.mappers

import com.model.FilterListDto
import com.moretech.entities.Service
import com.moretech.entities.ClientType
import com.moretech.entities.DepartmentType

class FilterListDtoMapper {
    companion object {
        fun mapServiceEntityToFilterListDto(services: List<Service>): List<FilterListDto> {
            return services.map {
                FilterListDto()
                    .id(it.id)
                    .name(it.name)
            }
        }

        fun mapClientTypeEntityToFilterListDto(clientTypes: List<ClientType>): List<FilterListDto> {
            return clientTypes.map {
                FilterListDto()
                    .id(it.id)
                    .name(it.name)
            }
        }

        fun mapDepartmentTypeEntityToFilterListDto(departmentTypes: List<DepartmentType>): List<FilterListDto> {
            return departmentTypes.map {
                FilterListDto()
                    .id(it.id)
                    .name(it.name)
            }
        }
    }
}
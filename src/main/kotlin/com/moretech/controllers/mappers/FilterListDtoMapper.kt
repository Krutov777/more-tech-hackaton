package com.moretech.controllers.mappers

import com.model.FilterListDto
import com.moretech.entities.Service
import com.moretech.entities.ClientType

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
    }
}
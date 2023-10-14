package com.moretech.controllers.mapper

import com.model.FilterListDto
import com.moretech.entities.Service

class FilterListMapper {
    companion object {
        fun mapServiceEntityToFilterListDto(services: List<Service>): List<FilterListDto> {
            return services.map {
                FilterListDto()
                    .id(it.id)
                    .name(it.name)
            }
        }
    }
}
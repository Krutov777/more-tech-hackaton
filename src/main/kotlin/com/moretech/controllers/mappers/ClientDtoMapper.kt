package com.moretech.controllers.mappers

import com.model.ClientDto
import com.moretech.entities.ClientType

class ClientDtoMapper {
    companion object {
        fun mapClientTypeToClientDto(clientType: ClientType) : ClientDto {
            return ClientDto()
                .id(clientType.id)
                .name(clientType.name)
        }
    }
}
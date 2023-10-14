package com.moretech.services

import com.moretech.entities.ClientType
import com.moretech.repositories.ClientTypeRepository
import org.springframework.stereotype.Service

@Service
class ClientTypeService(private val clientTypeRepository: ClientTypeRepository) {
    fun findAllClientTypes(): List<ClientType> = clientTypeRepository.findAll().toList()
}
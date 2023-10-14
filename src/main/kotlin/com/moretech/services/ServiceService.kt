package com.moretech.services

import com.moretech.repositories.ServiceRepository
import org.springframework.stereotype.Service

@Service
class ServiceService(
    private val serviceRepository: ServiceRepository
) {
    fun findAllServices(): List<com.moretech.entities.Service> = serviceRepository.findAll().toList()
}
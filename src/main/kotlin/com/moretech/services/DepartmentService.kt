package com.moretech.services

import com.model.DepartmentInfoResponseDto
import com.moretech.controllers.mappers.DepartmentInfoDtoMapper
import com.moretech.entities.ClientType
import com.moretech.entities.ClientTypeDepartment
import com.moretech.entities.ServiceDepartment
import com.moretech.repositories.*
import org.springframework.stereotype.Service

@Service
class DepartmentService(
    private val departmentRepository: DepartmentRepository,
    private val serviceDepartmentRepository: ServiceDepartmentRepository,
    private val serviceRepository: ServiceRepository,
    private val openHoursRepository: OpenHoursRepository,
    private val clientTypeRepository: ClientTypeRepository,
    private val clientTypeDepartmentRepository: ClientTypeDepartmentRepository
) {
    fun getDepartmentById(departmentId: Long): DepartmentInfoResponseDto {
        val department = departmentRepository.findById(departmentId).get()
        val serviceDepartment: List<ServiceDepartment> = department.id?.let { serviceDepartmentRepository.findAllByDepartmentId(it) } ?: listOf()
        val clientTypeDepartment: List<ClientTypeDepartment> = department.id?.let { clientTypeDepartmentRepository.findAllByDepartmentId(it) } ?: listOf()
        val clientTypeList: List<ClientType> = clientTypeDepartment.map { it.id?.clientTypeId }.let { clientTypeRepository.findAllByIdIn(it as List<Long>) }
        //val serviceList: List<com.moretech.entities.Service> = serviceDepartment.map { it.id?.serviceId }.let { serviceRepository.findAllByIdIn(it as List<Long>) }
        return DepartmentInfoDtoMapper.mapDepartmentEntityToDepartmentInfoDto(
            department,
            serviceDepartment,
            clientTypeList,
            department.openHours?.toList() ?: listOf()
        )
    }
}
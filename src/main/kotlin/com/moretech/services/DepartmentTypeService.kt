package com.moretech.services

import com.moretech.entities.DepartmentType
import com.moretech.repositories.DepartmentTypeRepository
import org.springframework.stereotype.Service

@Service
class DepartmentTypeService(private val departmentTypeRepository: DepartmentTypeRepository) {
    fun findAllDepartmentTypes(): List<DepartmentType> = departmentTypeRepository.findAll().toList()
}
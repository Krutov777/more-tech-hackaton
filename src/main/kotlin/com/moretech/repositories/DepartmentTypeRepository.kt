package com.moretech.repositories

import com.moretech.entities.DepartmentType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentTypeRepository: JpaRepository<DepartmentType, Long> {
}
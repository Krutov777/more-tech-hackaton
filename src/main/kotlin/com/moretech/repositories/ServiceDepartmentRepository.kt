package com.moretech.repositories

import com.moretech.entities.ServiceDepartment
import com.moretech.entities.ServiceDepartmentKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceDepartmentRepository : JpaRepository<ServiceDepartment, ServiceDepartmentKey> {
}
package com.moretech.repositories

import com.moretech.entities.ClientTypeDepartment
import com.moretech.entities.ClientTypeDepartmentKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientTypeDepartmentRepository: JpaRepository<ClientTypeDepartment, ClientTypeDepartmentKey> {
    fun findAllByDepartmentId(departmentId: Long): List<ClientTypeDepartment>
}
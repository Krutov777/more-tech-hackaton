package com.moretech.repositories

import com.moretech.entities.ClientTypeDepartment
import com.moretech.entities.ClientTypeDepartmentKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClientTypeDepartmentRepository : JpaRepository<ClientTypeDepartment, ClientTypeDepartmentKey> {
    fun findAllByDepartmentId(departmentId: Long): List<ClientTypeDepartment>

    @Query("SELECT DISTINCT c.id.departmentId " +
        "FROM ClientTypeDepartment c " +
        "WHERE c.id.clientTypeId IN :clientTypeIds " +
        "GROUP BY c.id.clientTypeId " +
        "HAVING COUNT(c.id.clientTypeId) >= :clientTypeIdsCount")
    fun findDepartmentIdsBy(
        @Param("clientTypeIds") clientTypeIds: List<Long>,
        @Param("clientTypeIdsCount") clientTypeIdsCount: Long
    ): Set<Long>
}
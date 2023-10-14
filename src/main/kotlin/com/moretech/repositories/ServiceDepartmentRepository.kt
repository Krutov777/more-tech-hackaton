package com.moretech.repositories

import com.moretech.entities.ServiceDepartment
import com.moretech.entities.ServiceDepartmentKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ServiceDepartmentRepository : JpaRepository<ServiceDepartment, ServiceDepartmentKey> {
    fun findAllByDepartmentId(departmentId: Long): List<ServiceDepartment>

    @Query("SELECT DISTINCT sd.id.departmentId " +
        "FROM ServiceDepartment sd " +
        "WHERE sd.id.serviceId IN :serviceIds " +
        "GROUP BY sd.id.departmentId " +
        "HAVING COUNT(sd.id.departmentId) >= :serviceIdsCount")
    fun findDepartmentIdsBy(
        @Param("serviceIds") serviceIds: List<Long>,
        @Param("serviceIdsCount") serviceIdsCount: Long
    ): Set<Long>
}
package com.moretech.repositories

import com.moretech.entities.ServiceAtm
import com.moretech.entities.ServiceAtmKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ServiceAtmRepository : JpaRepository<ServiceAtm, ServiceAtmKey> {
    fun findAllByAtmId(atmId: Long): List<ServiceAtm>

    @Query(
        "SELECT DISTINCT sa.id.atmId, COUNT(sa.id.atmId) " +
            "FROM ServiceAtm sa " +
            "WHERE sa.id.serviceId IN :serviceIds " +
            "GROUP BY sa.id.atmId " +
            "HAVING COUNT(sa.id.atmId) >= :serviceIdsCount"
    )
    fun findAtmIdsBy(
        @Param("serviceIds") serviceIds: List<Long>,
        @Param("serviceIdsCount") serviceIdsCount: Long
    ): Set<Long>
}
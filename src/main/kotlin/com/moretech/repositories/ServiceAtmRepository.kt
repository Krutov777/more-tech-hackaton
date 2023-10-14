package com.moretech.repositories

import com.moretech.entities.ServiceAtm
import com.moretech.entities.ServiceAtmKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceAtmRepository : JpaRepository<ServiceAtm, ServiceAtmKey> {
    fun findAllByAtmId(atmId: Long): List<ServiceAtm>
}
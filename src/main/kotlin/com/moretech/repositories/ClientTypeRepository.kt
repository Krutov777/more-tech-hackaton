package com.moretech.repositories

import com.moretech.entities.ClientType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientTypeRepository: JpaRepository<ClientType, Long> {
    fun findAllByIdIn(ids: List<Long>) : List<ClientType>
}
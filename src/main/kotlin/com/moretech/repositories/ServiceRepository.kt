package com.moretech.repositories

import com.moretech.entities.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : JpaRepository<Service, Long> {
    fun findAllByIdIn(ids: List<Long>) : List<Service>
}
package com.moretech.repositories

import com.moretech.entities.OpenHours
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OpenHoursRepository : JpaRepository<OpenHours, Long> {
}
package com.moretech.repositories

import com.moretech.entities.Atm
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AtmRepository : JpaRepository<Atm, Long> {
}
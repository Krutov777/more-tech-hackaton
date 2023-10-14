package com.moretech.repositories

import com.moretech.entities.Service
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : CrudRepository<Service, Long>
package com.moretech.entities

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class ServiceAtmKey (
    @Column(name = "service_id")
    open var serviceId: Long? = null,

    @Column(name = "atm_id")
    open var atmId: Long? = null,
) : Serializable
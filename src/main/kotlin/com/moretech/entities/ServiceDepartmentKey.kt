package com.moretech.entities

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class ServiceDepartmentKey(
    @Column(name = "service_id")
    open var serviceId: Long? = null,

    @Column(name = "department_id")
    open var departmentId: Long? = null
) : Serializable
package com.moretech.entities

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class ClientTypeDepartmentKey (
    @Column(name = "client_type_id")
    open var serviceId: Long? = null,

    @Column(name = "department_id")
    open var departmentId: Long? = null
) : Serializable
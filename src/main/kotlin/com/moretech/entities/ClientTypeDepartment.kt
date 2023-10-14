package com.moretech.entities

import javax.persistence.*

@Entity
open class ClientTypeDepartment(
    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    open var department: Department? = null,

    @ManyToOne
    @MapsId("clientTypeId")
    @JoinColumn(name = "client_type_id")
    open var clientType: ClientType? = null,

    @EmbeddedId
    open var id: ServiceDepartmentKey? = null
)
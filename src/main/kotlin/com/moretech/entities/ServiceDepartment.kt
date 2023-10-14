package com.moretech.entities

import javax.persistence.*

@Entity
open class ServiceDepartment(
    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    open var department: Department? = null,

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    open var service: Service? = null,

    @EmbeddedId
    open var id: ServiceDepartmentKey? = null
)
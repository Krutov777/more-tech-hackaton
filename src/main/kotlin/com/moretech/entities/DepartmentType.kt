package com.moretech.entities

import javax.persistence.Entity
import javax.persistence.*

@Entity
open class DepartmentType (
    open var name: String? = null,

    @OneToMany(mappedBy = "departmentType")
    open var department: MutableSet<Department>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
)
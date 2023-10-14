package com.moretech.entities

import javax.persistence.*

@Entity
open class Department(
    @Column(name = "sale_point_name")
    open var salePointName : String? = null,
    @Column(name = "address")
    open var address : String? = null,
    @Column(name = "status")
    open var status : String? = null,
    @Column(name = "rko")
    open var rko : String? = null,
    @Column(name = "department_type")
    open var departmentType : String? = null,
    @Column(name = "sale_point_format")
    open var salePointFormat : String? = null,
    @Column(name = "suo_availability", nullable = true)
    open var suoAvailability : Boolean? = null,
    @Column(name = "has_ramp", nullable = true)
    open var hasRamp : Boolean? = null,
    @Column(name = "latitude")
    open var latitude : Double? = null,
    @Column(name = "longitude")
    open var longitude: Double? = null,
    @Column(name = "metro_station", nullable = true)
    open var metroStation: String? = null,
    @Column(name = "distance")
    open var distance: Int? = null,

    @OneToMany(mappedBy = "department")
    open var openHours: MutableSet<OpenHours>? = null,

    @OneToMany(mappedBy = "department")
    open var serviceDepartment: MutableSet<ServiceDepartment>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
)

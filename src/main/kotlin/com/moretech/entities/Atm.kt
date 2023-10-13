package com.moretech.entities

import javax.persistence.*

@Entity
open class Atm(
    @Column(name = "address")
    open var address: String? = null,
    @Column(name = "latitude")
    open var latitude : Double? = null,
    @Column(name = "longitude")
    open var longitude: Double? = null,
    @Column(name = "all_day")
    open var allDay: Boolean? = null,
    @Column(name = "distance")
    open var distance: Int? = null,
    @Column(name = "metro_station", nullable = true)
    open var metroStation: String? = null,

    @OneToMany(mappedBy = "atm")
    open var serviceAtm: MutableSet<ServiceAtm>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
)

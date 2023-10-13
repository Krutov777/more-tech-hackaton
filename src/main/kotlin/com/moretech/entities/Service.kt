package com.moretech.entities

import javax.persistence.*

@Entity
open class Service(
    @Column(name = "name")
    open var name: String? = null,

    @OneToMany(mappedBy = "service")
    open var serviceAtm: MutableSet<ServiceAtm>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
)

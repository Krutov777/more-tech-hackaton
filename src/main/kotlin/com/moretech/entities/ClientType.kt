package com.moretech.entities

import javax.persistence.*

@Entity
open class ClientType(
    @Column(name = "name")
    open var name: String? = null,

    @OneToMany(mappedBy = "clientType")
    open var clientTypeDepartment: MutableSet<ClientTypeDepartment>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,
)
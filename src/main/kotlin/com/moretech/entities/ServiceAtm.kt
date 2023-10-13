package com.moretech.entities

import javax.persistence.*

@Entity
open class ServiceAtm(
    @Column(name = "service_capacity")
    @Enumerated(value = EnumType.STRING)
    open var serviceCapacity: ServiceCapacity? = null,
    @Column(name = "service_activity")
    @Enumerated(value = EnumType.STRING)
    open var serviceActivity: ServiceActivity? = null,

    @ManyToOne
    @MapsId("atmId")
    @JoinColumn(name = "atm_id")
    open var atm: Atm? = null,

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    open var service: Service? = null,

    @EmbeddedId
    open var id: ServiceAtmKey? = null
) {
    enum class ServiceCapacity {
        UNKNOWN, UNAVAILABLE, SUPPORTED
    }

    enum class ServiceActivity {
        UNKNOWN, UNAVAILABLE, AVAILABLE
    }
}

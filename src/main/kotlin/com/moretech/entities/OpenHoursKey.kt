package com.moretech.entities

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
open class OpenHoursKey(
    @Enumerated(value = EnumType.STRING)
    open var day: Days? = null,

    @Column(name = "type_work")
    @Enumerated(value = EnumType.STRING)
    open var typeWork: TypeWork? = null,

    @Column(name = "open_hours_id")
    open var openHoursId: Long? = null,
): Serializable {
    enum class Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum class TypeWork {
        INDIVIDUAL, LEGAL
    }
}
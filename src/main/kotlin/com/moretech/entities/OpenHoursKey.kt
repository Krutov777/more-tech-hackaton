package com.moretech.entities

import java.io.Serializable
import javax.persistence.*

@Embeddable
open class OpenHoursKey(
    @Enumerated(value = EnumType.STRING)
    open var day: Days? = null,

    @Column(name = "type_work")
    @Enumerated(value = EnumType.STRING)
    open var typeWork: TypeWork? = null,

    open var departmentId: Long? = null
): Serializable {
    enum class Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum class TypeWork {
        INDIVIDUAL, LEGAL
    }
}
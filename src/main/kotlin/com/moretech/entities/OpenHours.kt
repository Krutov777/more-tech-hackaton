package com.moretech.entities

import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "open_hours")
open class OpenHours(
    @Column(name = "start_time", nullable = true)
    open var startTime: LocalTime? = null,
    @Column(name = "end_time", nullable = true)
    open var endTime: LocalTime? = null,
    @Column(name = "type_work")
    @Enumerated(value = EnumType.STRING)
    open var typeWork: TypeWork? = null,

    @ManyToOne
    @JoinColumn(name = "department_id")
    open var department: Department? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Enumerated(value = EnumType.STRING)
    open var day: Days? = null,
) {
    enum class Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum class TypeWork {
        INDIVIDUAL, LEGAL
    }
}

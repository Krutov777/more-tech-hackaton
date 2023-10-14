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

    @ManyToOne
    @MapsId("departmentId")
    open var department: Department? = null,

    @EmbeddedId
    open var id: OpenHoursKey? = null
)

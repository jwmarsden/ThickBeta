package com.ventia.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "LOCATION_STATUS")
data class LocationStatus(

    @Id
    @Column(nullable = false)
    val id: Int,

    @Column(nullable = false)
    var systemStatus: String,

    @Column(nullable = false)
    var status: String,

    val description: String,

    @Column(nullable = false)
    val active: Boolean,

)

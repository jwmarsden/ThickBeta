package com.ventia.entities

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "system-id-seq", sequenceName = "SYSTEM_ID_SEQ", initialValue = 20, allocationSize = 10)
@Table(name = "SYSTEM")
data class SystemEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system-id-seq")
    @Column(nullable = false)
    val id: Long?,

    @Column(nullable = false)
    val system: String,

    val description: String,

    @Column(nullable = false)
    val graph: Boolean,

    @Column(nullable = false)
    val active: Boolean,

)

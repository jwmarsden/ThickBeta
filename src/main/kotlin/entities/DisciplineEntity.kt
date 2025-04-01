package com.ventia.entities

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "discipline-id-seq", sequenceName = "DISCIPLINE_ID_SEQ", initialValue = 550, allocationSize = 10)
@Table(name = "DISCIPLINE")
data class DisciplineEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline-id-seq")
    @Column(nullable = false)
    val id: Long?,

    val discipline: String,

    val description: String,

    @Column(nullable = false)
    val active: Boolean,

)

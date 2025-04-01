package com.ventia.entities

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "location_system_hierarchy-id-seq", sequenceName = "LOCATION_SYSTEM_HIERARCHY_ID_SEQ", initialValue = 10, allocationSize = 10)
@Table(name = "LOCATION_SYSTEM_HIERARCHY")
data class LocationSystemHierarchyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_system_hierarchy-id-seq")
    @Column(nullable = false)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    val system: SystemEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    val parent: LocationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    val child: LocationEntity,
)

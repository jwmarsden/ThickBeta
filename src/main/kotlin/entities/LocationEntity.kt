package com.ventia.entities

import jakarta.persistence.*

@Entity
@SequenceGenerator(name = "location-id-seq", sequenceName = "LOCATION_ID_SEQ", initialValue = 100, allocationSize = 10)
@Table(name = "LOCATION")
data class LocationEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location-id-seq")
    @Column(nullable = false)
    val id: Long?,

    @Column(nullable = false)
    val key: String,

    val description: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status")
    @Column(nullable = false)
    val status: LocationStatusEntity,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline")
    val discipline: DisciplineEntity?,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent_id")
    val parents: Set<LocationSystemHierarchyEntity>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "LOCATION_SYSTEM_HIERARCHY",
        joinColumns = [JoinColumn(name = "location_id")],
        inverseJoinColumns = [JoinColumn(name = "parent_id")]
    )
    val children: Set<LocationSystemHierarchyEntity>,

)

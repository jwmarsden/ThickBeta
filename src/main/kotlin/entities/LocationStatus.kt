package com.ventia.entities

data class LocationStatus(

    val id: Int,

    var systemStatus: String,

    var status: String,

    var description: String,

    val active: Boolean,

)

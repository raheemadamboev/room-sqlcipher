package xyz.teamgravity.roomsqlcipher.data.model

import xyz.teamgravity.roomsqlcipher.core.constant.Position

data class FootballerModel(
    val id: Long,
    val name: String,
    val number: Int,
    val ranking: Int,
    val position: Position,
)

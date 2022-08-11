package xyz.teamgravity.roomsqlcipher.data.model

import xyz.teamgravity.roomsqlcipher.core.constant.Position

data class FootballerModel(
    val id: Long = 0,
    val name: String,
    val ranking: Int,
    val position: Position,
)

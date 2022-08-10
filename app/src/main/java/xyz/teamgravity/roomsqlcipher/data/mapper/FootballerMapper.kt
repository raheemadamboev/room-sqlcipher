package xyz.teamgravity.roomsqlcipher.data.mapper

import xyz.teamgravity.roomsqlcipher.data.local.entity.FootballerEntity
import xyz.teamgravity.roomsqlcipher.data.model.FootballerModel

fun FootballerEntity.toModel(): FootballerModel {
    return FootballerModel(
        id = id,
        name = name,
        number = number,
        ranking = ranking,
        position = position
    )
}

fun FootballerModel.toEntity(): FootballerEntity {
    return FootballerEntity(
        id = id,
        name = name,
        number = number,
        ranking = ranking,
        position = position
    )
}
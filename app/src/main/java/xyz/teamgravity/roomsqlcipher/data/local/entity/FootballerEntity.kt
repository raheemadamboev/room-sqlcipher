package xyz.teamgravity.roomsqlcipher.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import xyz.teamgravity.roomsqlcipher.core.constant.Position
import xyz.teamgravity.roomsqlcipher.data.local.constant.FootballerConst

@Entity(tableName = FootballerConst.TABLE_FOOTBALLER)
data class FootballerEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val name: String,
    val number: Int,
    val ranking: Int,
    val position: Position,
)

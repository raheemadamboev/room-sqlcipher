package xyz.teamgravity.roomsqlcipher.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.teamgravity.roomsqlcipher.data.local.constant.FootballerConst
import xyz.teamgravity.roomsqlcipher.data.local.dao.FootballerDao
import xyz.teamgravity.roomsqlcipher.data.local.entity.FootballerEntity

@Database(
    entities = [FootballerEntity::class],
    version = FootballerConst.VERSION,
    exportSchema = false
)
abstract class FootballerDatabase : RoomDatabase() {

    abstract fun footballerDao(): FootballerDao
}
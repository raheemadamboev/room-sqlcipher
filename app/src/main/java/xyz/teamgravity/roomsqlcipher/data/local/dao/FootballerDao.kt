package xyz.teamgravity.roomsqlcipher.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.roomsqlcipher.data.local.constant.FootballerConst.TABLE_FOOTBALLER
import xyz.teamgravity.roomsqlcipher.data.local.entity.FootballerEntity

@Dao
interface FootballerDao {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFootballers(footballers: List<FootballerEntity>)

    @Transaction
    suspend fun replaceFootballers(footballers: List<FootballerEntity>) {
        deleteFootballers()
        insertFootballers(footballers)
    }

    ///////////////////////////////////////////////////////////////////////////
    // DELETE
    ///////////////////////////////////////////////////////////////////////////

    @Query("DELETE FROM $TABLE_FOOTBALLER")
    suspend fun deleteFootballers()

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @Query("SELECT * FROM $TABLE_FOOTBALLER ORDER BY id ASC")
    fun getFootballers(): Flow<List<FootballerEntity>>
}
package xyz.teamgravity.roomsqlcipher.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import xyz.teamgravity.roomsqlcipher.data.local.dao.FootballerDao
import xyz.teamgravity.roomsqlcipher.data.mapper.toEntity
import xyz.teamgravity.roomsqlcipher.data.mapper.toModel
import xyz.teamgravity.roomsqlcipher.data.model.FootballerModel

class FootballerRepository(
    private val dao: FootballerDao,
) {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    suspend fun replaceFootballers(footballers: List<FootballerModel>) {
        withContext(Dispatchers.IO) {
            dao.replaceFootballers(footballers.map { it.toEntity() })
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getFootballers(): Flow<List<FootballerModel>> {
        return dao.getFootballers().map { entities -> entities.map { it.toModel() } }
    }
}
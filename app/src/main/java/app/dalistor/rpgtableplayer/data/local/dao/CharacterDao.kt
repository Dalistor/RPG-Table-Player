package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.CharacterEntity

@Dao
@JvmSuppressWildcards
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterEntity: CharacterEntity): Long

    @Query("SELECT * FROM characters WHERE sessionId = :sessionId")
    suspend fun getAllBySessionId(sessionId: Long): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getById(id: Long): CharacterEntity

    @Delete
    suspend fun delete(characterEntity: CharacterEntity): Int
}

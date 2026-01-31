package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.CharacterAttrsEntity

@Dao
@JvmSuppressWildcards
interface CharacterAttrsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterAttrsEntity: CharacterAttrsEntity): Long

    @Query("SELECT * FROM character_attributes WHERE characterId = :characterId")
    suspend fun getAllByCharacterId(characterId: Long): List<CharacterAttrsEntity>

    @Delete
    suspend fun delete(characterAttrsEntity: CharacterAttrsEntity): Int
}

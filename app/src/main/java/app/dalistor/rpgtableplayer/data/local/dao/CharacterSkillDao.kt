package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.CharacterSkillEntity

@Dao
@JvmSuppressWildcards
interface CharacterSkillDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterSkillEntity: CharacterSkillEntity): Long

    @Query("SELECT * FROM character_skills WHERE characterId = :characterId")
    suspend fun getAllByCharacterId(characterId: Long): List<CharacterSkillEntity>

    @Delete
    suspend fun delete(characterSkillEntity: CharacterSkillEntity): Int
}

package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryEntity

@Dao
@JvmSuppressWildcards
interface CharacterInventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterInventoryEntity: CharacterInventoryEntity): Long

    @Query("SELECT * FROM character_inventory WHERE characterId = :characterId")
    suspend fun getByCharacterId(characterId: Long): CharacterInventoryEntity?

    @Delete
    suspend fun delete(characterInventoryEntity: CharacterInventoryEntity): Int
}
